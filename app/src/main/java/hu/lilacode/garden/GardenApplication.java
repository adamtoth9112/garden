package hu.lilacode.garden;

import android.app.Application;

import hu.lilacode.garden.ui.UIModule;

public class GardenApplication extends Application {

    public static GardenApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.MOCK) {
            injector = DaggerMockGardenApplicationComponent.builder().uIModule(new UIModule(this)).build();
        } else {
            injector = DaggerGardenApplicationComponent.builder().uIModule(new UIModule(this)).build();
        }
    }
}
