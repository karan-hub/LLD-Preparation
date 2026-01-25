
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class LightThemeButton implements Button {

    @Override
    public void render() {
        System.out.println("Light Theme Button");
    }

}

class DarkThemeButton implements Button {

    @Override
    public void render() {
        System.out.println("Dark Theme Button");
    }

}

class LightThemeCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Light Theme Checkbox");
    }

}

class DarkThemeCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Dark Theme Checkbox");
    }

}

interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class LightThemeFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new LightThemeButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightThemeCheckbox();
    }

}

class DarkThemeFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkThemeCheckbox();
    }

}

class UIService {
    private final Button button;
    private final Checkbox checkbox;

    public UIService(UIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void Screen() {
        button.render();
        checkbox.render();
    }
}

public class Solution {
    public static void main(String[] args) {
        UIFactory factory = new LightThemeFactory();
        UIService service = new UIService(factory);
        service.Screen();
    }
}
