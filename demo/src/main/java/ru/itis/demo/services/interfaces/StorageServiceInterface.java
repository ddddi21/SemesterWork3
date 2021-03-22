package ru.itis.demo.services.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.demo.models.User;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageServiceInterface {

    void init();

    void store(MultipartFile file, User user);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}