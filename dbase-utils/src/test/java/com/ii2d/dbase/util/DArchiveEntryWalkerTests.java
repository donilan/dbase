//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.apache.commons.compress.archivers.ArchiveEntry;

/**
 * @author Doni
 * @since 2012-9-11
 * @version $id$
 * 
 */
public class DArchiveEntryWalkerTests extends TestCase {

	public void testWalk() throws IOException {
		TestWalker w = new TestWalker();
		w.walk(DResourceUtils.getResourceAsArchiveInputStream("classpath:junit"), new ArrayList<Object>());
	}
	
	private class TestWalker extends DArchiveEntryWalker<Object> {

		@Override
		protected void handleFile(ArchiveEntry entry, Collection<Object> results) {
			super.handleFile(entry, results);
		}

		@Override
		protected void handleDirectory(ArchiveEntry entry,
				Collection<Object> results) {
			super.handleDirectory(entry, results);
		}
		
	}
}
