package view;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.Map;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;

import org.junit.Test;

import error_checking.InvalidArgumentsException;

public class TestSheet {
	@Test
	public void testCommandGet(){
		Locale locale=new Locale("en", "US");
		MenuView menuView=new MenuView(locale,new TabPane(), 0,0);
		Map<String, Locale> map=menuView.getLocaleMap();
		assertEquals("en_US",map.get("English").toString());
		assertEquals("cn_CN",map.get("中文").toString());
		assertEquals("fr_FR",map.get("Français").toString());

	}

}
