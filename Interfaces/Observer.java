import java.util.List;

public interface Observer {

    void notify(List<Positionable> drawables);
}