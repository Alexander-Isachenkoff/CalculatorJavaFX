package ru.isachenkoff.calculator.data;

import ru.isachenkoff.calculator.operations.CalculationResult;

public class CalculationResultDAO extends DAO<CalculationResult>
{
    protected Class<CalculationResult> getLoadingClass() {
        return CalculationResult.class;
    }
}
