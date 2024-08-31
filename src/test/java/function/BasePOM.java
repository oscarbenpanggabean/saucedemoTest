package function;

import org.openqa.selenium.interactions.Actions;

import driverFactory.BaseCode;

public class BasePOM extends BaseCode {

    protected Actions action; // Grants low level Selenium's Actions class function.
    protected GeneralAction gen_act; // Grants general pre-made Actions.
    protected GeneralFetch gen_fetch; // Grants general pre-made data fetching process.
    protected GeneralSupport gen_sprt; // Grants general supporting functions.
    protected GeneralWait gen_wait;

    public BasePOM() {
        super();
        this.gen_act = new GeneralAction();
        this.gen_fetch = new GeneralFetch();
        this.gen_sprt = new GeneralSupport();
        this.gen_wait = new GeneralWait();
    }
}
