package com.hongkailiu.test.app.java7.nio;

import lombok.Setter;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by hongkailiu on 2015-04-30.
 */
public class MyWatcher implements Callable<Object> {

    private Path path;
    @Setter private volatile boolean stopFlag = false;

    public MyWatcher(Path path) {
        this.path = path;
    }

    @Override public Object call() throws Exception {
        // Sanity check - Check if path is a folder
        try {
            Boolean isFolder =
                (Boolean) Files.getAttribute(path, "basic:isDirectory", LinkOption.NOFOLLOW_LINKS);
            if (!isFolder) {
                throw new IllegalArgumentException("Path: " + path + " is not a folder");
            }
        } catch (IOException ioe) {
            // Folder does not exists
            ioe.printStackTrace();
        }

        System.out.println("Watching path: " + path);

        // We obtain the file system of the Path
        FileSystem fs = path.getFileSystem();

        // We create the new WatchService using the new try() block
        try (WatchService service = fs.newWatchService()) {

            // We register the path to the service
            // We watch for creation events
            path.register(service, StandardWatchEventKinds.ENTRY_CREATE);

            // Start the infinite polling loop
            WatchKey key = null;
            while (!stopFlag) {
                //key = service.take();
                key = service.poll(1, TimeUnit.SECONDS);
                System.out.println("stopFlag: " + stopFlag);
                // Dequeueing events
                if (key!=null) {
                    WatchEvent.Kind<?> kind = null;
                    for (WatchEvent<?> watchEvent : key.pollEvents()) {
                        // Get the type of the event
                        kind = watchEvent.kind();
                        if (StandardWatchEventKinds.OVERFLOW == kind) {
                            continue; //loop
                        } else if (StandardWatchEventKinds.ENTRY_CREATE == kind) {
                            // A new Path was created
                            Path newPath = ((WatchEvent<Path>) watchEvent).context();
                            // Output
                            System.out.println("New path created: " + newPath);
                        }
                    }

                    if (!key.reset()) {
                        break; //loop
                    }
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return null;
    }
}
