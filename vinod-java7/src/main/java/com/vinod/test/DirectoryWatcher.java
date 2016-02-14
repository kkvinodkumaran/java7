package com.vinod.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatcher {

	public static void main(String[] args) {
		// Obtain a path reference to your watchable directory:
		Path tmpPath = Paths.get("D:/Pretech Files");
		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();
			// Register the directory with the WatchService for all types of
			// events
			tmpPath.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
			// Initiate the infinite loop and start taking the events:
			for (;;) {
				WatchKey key = watchService.take();
				// Run through the events on the key:
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					switch (kind.name()) {
					case "ENTRY_CREATE":
						System.out.println("Directory created: " + event.context());
						break;
					case "ENTRY_MODIFY":
						System.out.println("Directory Modified: " + event.context());
						break;

					}
				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}