package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static List<String> stringArrayList = new LinkedList<>();

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String string: stringList) {
            if (string != null)
                System.out.println(string.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public StringBuilder fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (String string : stringList) {
            processorName.append(string).append(' ');
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file){
        try {
            informationScanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (informationScanner.hasNext()) {
                sb.append(informationScanner.nextLine());
            }
            processorVersion = sb.toString();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (informationScanner != null)
                informationScanner.close();
        }
    }
}
