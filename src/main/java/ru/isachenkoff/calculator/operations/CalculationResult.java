package ru.isachenkoff.calculator.operations;

import javax.persistence.*;

@Entity
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private double result;
    private String statement;
    
    public Long getId() {return id;}
    
    public void setId(Long id) {this.id = id;}
    
    public CalculationResult() {}
    
    public CalculationResult(double result, String statement) {
        this.result = result;
        this.statement = statement;
    }
    
    public double getResult() {
        return result;
    }
    
    public String getFormattedResult() {
        return AbstractOperation.format(result);
    }
    
    public String getStatement() {
        return statement;
    }
    
    public void setStatement(String statement) {
        this.statement = statement;
    }
    
    public void setResult(double result) {
        this.result = result;
    }
    
    @Override
    public String toString() {
        return statement + AbstractOperation.format(result);
    }
}
