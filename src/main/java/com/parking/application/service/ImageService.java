package com.parking.application.service;

import java.io.IOException;

import org.springframework.util.concurrent.ListenableFuture;

import com.google.zxing.WriterException;

public interface ImageService {
	
	public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException;

	public ListenableFuture<byte[]> generateQRCodeAsync(String text, int width, int height) throws Exception;
	
	public void purgeCache();
}
