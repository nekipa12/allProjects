package edu.shag.lesson15.fileManagerInThreads.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import edu.shag.lesson15.fileManagerInThreads.controller.Work;
import edu.shag.lesson15.fileManagerInThreads.model.CopyTh;


public class Main {

	public static void main(String[] args) {
		Work aWork = new Work();
		aWork.start();
	}
}
