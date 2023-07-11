package org.example;

import java.io.File;

public class DigitalAssetManager {
    private File icon;
    private File assetsFolder;

    public DigitalAssetManager(File icon, File assetsFolder) {
        if (icon == null || !icon.isFile() || !icon.exists()) {
            throw new IllegalArgumentException("Icon is null, not a file, or doesn't exist.");
        }
        this.icon = icon;

        if (assetsFolder == null || !assetsFolder.isDirectory() || !assetsFolder.exists()) {
            throw new IllegalArgumentException("Assets folder is null, not a folder, or doesn't exist.");
        }
        this.assetsFolder = assetsFolder;
    }

    public int getAssetCount() {
        return assetsFolder.listFiles().length;
    }
}
