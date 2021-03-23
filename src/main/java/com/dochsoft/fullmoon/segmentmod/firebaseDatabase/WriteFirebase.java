package com.dochsoft.fullmoon.segmentmod.firebaseDatabase;

/*import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import net.minecraft.client.Minecraft;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class WriteFirebase {

    public static void writeFirebase() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");

        LocalDate nowDate = LocalDate.now();
        LocalDateTime nowTime = LocalDateTime.now();
        String nowDateString = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String nowTimeString = nowTime.format(DateTimeFormatter.ofPattern("HH-mm-ss"));

        DatabaseReference executeLog = ref.child(nowDateString).child(nowTimeString);

        executeLog.child("UserName").setValueAsync(Minecraft.getMinecraft().player.getName());
        executeLog.child("UserUUID").setValueAsync(Minecraft.getMinecraft().player.getUniqueID());
        executeLog.child("ModList").setValueAsync(getPlayerModList());
        executeLog.child("ResourcepackList").setValueAsync(getPlayerResourcepackList());


    }

    public static List<String> getPlayerModList() {
        String minecraftPath = System.getenv("APPDATA") + "\\.minecraft\\mods";

        File folder = new File(minecraftPath);

        if (folder.exists()) {
            return Arrays.asList(folder.list());
        }
        return null;
    }

    public static List<String> getPlayerResourcepackList() {
        String minecraftPath = System.getenv("APPDATA") + "\\.minecraft\\resourcepacks";

        File folder = new File(minecraftPath);

        if (folder.exists()) {
            return Arrays.asList(folder.list());
        }
        return null;
    }
}*/
