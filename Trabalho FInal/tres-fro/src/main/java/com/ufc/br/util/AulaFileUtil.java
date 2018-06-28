package com.ufc.br.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class AulaFileUtil {
    public static void salvarImagem(String caminho, MultipartFile imagem){
        File file = new File(caminho);
        try {
            FileUtils.writeByteArrayToFile(file, imagem.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
