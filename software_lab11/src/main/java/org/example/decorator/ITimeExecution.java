package org.example.decorator;

import org.example.strategy.Student;
import java.util.List;

public interface ITimeExecution {
    long executionTime(List<Student> studenti);
}
