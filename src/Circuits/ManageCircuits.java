package Circuits;

import java.io.*;
import java.util.HashMap;

public class ManageCircuits {
    private HashMap<String, Circuit> circuits;
    private String filePath;

    public ManageCircuits(String filePath) {
        this.circuits = new HashMap<>();
        this.filePath = filePath != null ? filePath : "Data/circuits.dat"; // Caminho padrão
    }

    public void loadCircuits() throws IOException, ClassNotFoundException {
        File ficheiro = new File(filePath);

        if (!ficheiro.exists()) {
            throw new IOException("Ficheiro não encontrado: " + ficheiro.getAbsolutePath());
        }

        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(ficheiro))) {
            circuits = (HashMap<String, Circuit>) oIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao carregar os circuitos: " + e.getMessage(), e);
        }
    }

    public void saveCircuits() throws IOException {
        File pasta = new File("Data");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File ficheiro = new File(pasta, "circuitos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro))) {
            oos.writeObject(circuits);
        } catch (IOException e) {
            throw new IOException("Erro ao guardar os circuitos: " + e.getMessage(), e);
        }
    }

    public HashMap<String, Circuit> getCircuits() {
        return circuits;
    }

    public void addCircuit(String key, Circuit circuit) {
        circuits.put(key, circuit);
    }

    public void removeCircuit(String key) {
        circuits.remove(key);
    }
}


