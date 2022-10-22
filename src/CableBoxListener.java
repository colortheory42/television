import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CableBoxListener implements KeyListener {
    private final Television tv;
    private final CableBox cableBox;

    CableBoxListener(Television tv, CableBox cableBox) {
        this.tv = tv;
        this.cableBox = cableBox;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //ignore
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            var stuff = this.cableBox.enter();
            stuff.ifPresent(cc -> tv.changeChannel(cc.pp(), cc.channel()));
        } else if (e.getKeyCode() == 38) {
            var stuff = this.cableBox.up();
            stuff.ifPresent(cc -> tv.changeChannel(cc.pp(), cc.channel()));
        } else if (e.getKeyCode() == 40) {
            var stuff = this.cableBox.down();
            stuff.ifPresent(cc -> tv.changeChannel(cc.pp(), cc.channel()));
        } else if (e.getKeyCode() >= 96 && e.getKeyCode() <= 105) {
            var stuff = this.cableBox.number(e.getKeyCode() - 96);
            tv.updateOutput(String.valueOf(stuff));
        } else if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
            var stuff = this.cableBox.number(e.getKeyCode() - 48);
            tv.updateOutput(String.valueOf(stuff));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ignore
    }
}
