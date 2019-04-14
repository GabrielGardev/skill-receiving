package pr0304Barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.AbstractUnit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@SuppressWarnings("unchecked")
	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		try {
			Class<? extends Unit> aClass = (Class<? extends Unit>) Class
					.forName(UnitFactoryImpl.UNITS_PACKAGE_NAME + unitType);

			Constructor constructor = aClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			unit = (Unit) constructor.newInstance();
		} catch (Exception e) {

		}

		return unit;
	}
}
