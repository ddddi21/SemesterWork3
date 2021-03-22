package ru.itis.demo.controllers;


import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.helpers.storage.StorageFileNotFoundException;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.StorageServiceInterface;


@Controller
public class FileUploadController {

    @Autowired
    private final StorageServiceInterface storageService;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;

    @Autowired
    public FileUploadController(StorageServiceInterface storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/upload")
//    @ResponseBody
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "upload_form";
    }

    //скачивание файла
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
//    @ResponseBody @RequestParam("file")
    public String handleFileUpload(@RequestParam("file")MultipartFile file,
                                   RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetailsImpl user) {
        Optional<User> userFromDB = usersRepositoryInterface.findByEmail(user.getUsername());
        if(userFromDB.isPresent()){
            if(!file.isEmpty()) {
                try {
                    storageService.store(file, userFromDB.get()); //TODO(fix)
                    redirectAttributes.addFlashAttribute("message",
                            "You successfully uploaded " + file.getOriginalFilename() + "!");
                } catch (Exception e){
                    redirectAttributes.addFlashAttribute("message",
                            "Upload is failed" + file.getOriginalFilename() + "because" + e.getMessage());
                }
            } else {
                redirectAttributes.addFlashAttribute("message",
                        "Upload is failed " + file.getOriginalFilename() + " because file is empty");
            }
        } else{
            redirectAttributes.addFlashAttribute("message",
                    "Upload is failed " + file.getOriginalFilename() + " because file is empty");
        }



        return "redirect:/profile";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
