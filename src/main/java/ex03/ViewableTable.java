package ex03;
import ex02.View;
import ex02.ViewableResult;

public class ViewableTable extends ViewableResult {
    public View getView() {
        return new ViewTable();
    }
}
