/*
 * Copyright (C) 2005-2011 Alfresco Software Limited.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have received a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing"
 */

package org.alfresco.extension.bulkfilesystemimport.importfilters;


import java.util.regex.Pattern;

import org.alfresco.extension.bulkfilesystemimport.ImportableItem;
import org.alfresco.extension.bulkfilesystemimport.ImportFilter;


/**
 * This class is an <code>ImportFilter</code> that filters out files and/or folders whose name, excluding
 * path, matches the configured regular expression. 
 *
 * @author Peter Monks (pmonks@alfresco.com)
 */
public class FileNameRegexImportFilter
    implements ImportFilter
{
    private final Pattern pattern;
    
    
    /**
     * Simple constructor for a FileNameRegexSourceFilter
     * 
     * @param filenameRegex The regex to use to match against file and folder names <i>(must not be null)</i>.
     */
    public FileNameRegexImportFilter(final String filenameRegex)
    {
        this.pattern = Pattern.compile(filenameRegex);
    }
    
    
    /**
     * @see org.alfresco.extension.bulkfilesystemimport.ImportFilter#shouldFilter(org.alfresco.extension.bulkfilesystemimport.ImportableItem)
     */
    public boolean shouldFilter(final ImportableItem importableItem)
    {
        return(pattern.matcher(importableItem.getHeadRevision().getContentFile().getName()).matches());
    }

}
