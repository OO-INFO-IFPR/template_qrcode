package com.efigenio.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class PixService {

    public static String gerarStringPix(String chavePix, String valor, String descricao) {
        return "00020126330014BR.GOV.BCB.PIX0114" + chavePix + "5204000053039865802BR5913Test User6009" + descricao
                + "6304ABCD";
    }

    public static String gerarQrCodeBase64(String pixString) {
        try {
            Map<EncodeHintType, Object> hintMap = new HashMap<>();
            hintMap.put(EncodeHintType.MARGIN, 1);

            MultiFormatWriter writer = new MultiFormatWriter();
            BitMatrix bitMatrix = writer.encode(pixString, BarcodeFormat.QR_CODE, 200, 200, hintMap);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            com.google.zxing.client.j2se.MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}