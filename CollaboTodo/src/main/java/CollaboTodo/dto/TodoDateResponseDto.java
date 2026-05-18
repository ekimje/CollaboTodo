package CollaboTodo.dto;

import CollaboTodo.Entity.Todo;

import java.time.LocalDate;
import java.util.List;

public class TodoDateResponseDto {
    private LocalDate selectedDate;
    private LocalDate previousDate;
    private LocalDate nextDate;
    private List<Todo> todos;

    public TodoDateResponseDto(LocalDate selectedDate, List<Todo> todos){
        this.selectedDate = selectedDate;
        this.previousDate = selectedDate.minusDays(1);
        this.nextDate = selectedDate.plusDays(1);
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public LocalDate getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDate nextDate) {
        this.nextDate = nextDate;
    }

    public LocalDate getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(LocalDate previousDate) {
        this.previousDate = previousDate;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(LocalDate selectedDate) {
        this.selectedDate = selectedDate;
    }
}
