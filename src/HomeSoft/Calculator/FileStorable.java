package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public interface FileStorable {
    public void readFile(String fileName);
    public void writeFile(String fileName);
    public boolean existFile(String fileName);
    public boolean validateFile(String fileName);
    public <T> T parseLine(String value);
    public String toFile();
}
