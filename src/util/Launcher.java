package util;

import model.Memory;
import model.User;
import service.MemoryServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

class Launcher {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        printByUserName();
        addByUser();
        printAll();
    }

    private static void printAll() throws SQLException, ClassNotFoundException {
        ArrayList<Memory> allInMemory = MemoryServiceImpl.selectAllMemories();
        for (Memory memory : allInMemory) {
            memory.printData();
        }
    }

    private static void addByUser() throws SQLException, ClassNotFoundException {
        Memory memory = new Memory("how are you?", "i am fine");
        User user = new User(memory, "senthil", "selva");
        MemoryServiceImpl.addDataToMemory(user);
    }

    private static void printByUserName() throws SQLException, ClassNotFoundException {
        ArrayList<Memory> memoriesByUsername = MemoryServiceImpl.selectMemoriesByUsername("selva");
        for (Memory memory : memoriesByUsername) {
            memory.printData();
        }
    }
}
