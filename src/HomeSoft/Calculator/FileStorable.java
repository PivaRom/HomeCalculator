package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public interface FileStorable {
    void readFile(String fileName);
    void writeFile(String fileName);
    boolean existFile(String fileName);
    boolean validateFile(String fileName);
}
