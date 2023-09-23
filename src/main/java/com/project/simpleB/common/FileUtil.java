package com.project.simpleB.common;

import com.project.simpleB.file.dto.FileInfoDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUtil {

    private static final String UPLOAD_PATH = Paths.get(System.getProperty("user.home"), "simple_prj").toString();

    public static List<FileInfoDTO> uploadFiles(List<MultipartFile> files) throws IOException {
        File dir = new File(UPLOAD_PATH);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        List<FileInfoDTO> fileList = new ArrayList<>();

        for (MultipartFile file : files) {
            fileList.add(uploadFile(file));
        }

        return fileList;
    }

    private static FileInfoDTO uploadFile(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String saveName = generateSaveName(originalName);
        File uploadFile = new File(getFilePath(saveName));
        file.transferTo(uploadFile);

        return FileInfoDTO.builder()
                .originalName(originalName)
                .saveName(saveName)
                .build();
    }

    private static String generateSaveName(String originalFilename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(originalFilename);

        return uuid + "." + extension;
    }

    public static void deleteFiles(List<FileInfoDTO> fileList) {
        for (FileInfoDTO file : fileList) {
            deleteFile(file.getSaveName());
        }
    }

    private static void deleteFile(String saveName) {
        File file = new File(getFilePath(saveName));

        if (file.exists()) {
            file.delete();
        }
    }

    private static String getFilePath(String saveName) {
        return UPLOAD_PATH + File.separator + saveName;
    }
}
