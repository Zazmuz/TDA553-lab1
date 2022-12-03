package test.VehicleMods;

import org.junit.Test;
import src.VehicleMods.AngledPlatformMod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


public class AngledPlatformModTest {

    @Test
    public void test_angled_platform_only_allowed_angles() {
        AngledPlatformMod platformMod = new AngledPlatformMod(90) {
            @Override
            protected boolean canBeMoved() {
                return true;
            }
        };

        platformMod.setAngle(-10);
        assertEquals(0, platformMod.getAngle(), 0.0);
        platformMod.setAngle(169);
        assertEquals(90, platformMod.getAngle(), 0.0);
        platformMod.setAngle(69);
        assertEquals(69, platformMod.getAngle(), 0.0);
    }

}
