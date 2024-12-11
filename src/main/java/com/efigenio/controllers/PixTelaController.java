package com.efigenio.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import com.efigenio.services.PixService;

public class PixTelaController {

    @FXML
    private TextField valorField;

    @FXML
    private TextField descricaoField;

    @FXML
    private ImageView qrCodeImage;

    @FXML
    public void gerarPix() {
        String chavePix = "+55991776067";
        String valor = valorField.getText();
        String descricao = descricaoField.getText();

        String pixString = PixService.gerarStringPix(chavePix, valor, descricao);

        String qrCodeBase64 = PixService.gerarQrCodeBase64(pixString);

        byte[] imageBytes = Base64.getDecoder().decode(qrCodeBase64);
        Image qrCode = new Image(new ByteArrayInputStream(imageBytes));
        qrCodeImage.setImage(qrCode);
    }
}