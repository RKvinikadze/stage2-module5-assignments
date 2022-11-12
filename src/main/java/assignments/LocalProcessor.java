package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String ProcessorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner) {
        this.processorName = processorName;
        this.period = period;
        this.ProcessorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String string: stringList) {
            System.out.println(string.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder sb = new StringBuilder();
        for (String string : stringList) {
            sb.append(string).append(' ');
        }
        processorName = sb.toString();
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
            ProcessorVersion = sb.toString();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (informationScanner != null)
                informationScanner.close();
        }



    }
}
