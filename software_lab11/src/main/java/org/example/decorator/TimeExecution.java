package org.example.decorator;

import org.example.strategy.IStudentiExport;
import org.example.strategy.Student;
import java.util.List;

public class TimeExecution implements ITimeExecution {
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        exporter.doExport(studenti);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Timpul de executie: " + duration + " ms");
        return duration;
    }
}
