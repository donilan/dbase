//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;

/**
 * @author Doni
 * @since 2012-9-11
 * @version $id$
 * 
 */
public abstract class DArchiveEntryWalker<T> {

	protected final void walk(ArchiveInputStream in, Collection<T> results) throws IOException {
		if (in == null) {
            throw new NullPointerException("Start entry is null");
        }
		ArchiveEntry entry = in.getNextEntry();
		while(entry != null) {
			if(entry.isDirectory()) {
				handleDirectory(entry, results);
			} else {
				handleFile(entry, results);
			}
			entry = in.getNextEntry();
		}
	}
	
	protected void handleFile(ArchiveEntry entry, Collection<T> results) {
        // do nothing - overridable by subclass
	}
	
	protected void handleDirectory(ArchiveEntry entry, Collection<T> results) {
        // do nothing - overridable by subclass
	}
}
