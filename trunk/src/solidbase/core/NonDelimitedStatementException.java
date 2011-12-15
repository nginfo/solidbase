/*--
 * Copyright 2006 Ren� M. de Bloois
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package solidbase.core;

import solidbase.util.FileLocation;


/**
 * Exception that is thrown when a statement is not delimited with the current delimiter.
 *
 * @author Ren� M. de Bloois
 */
public class NonDelimitedStatementException extends CommandFileException
{
	/**
	 * Constructor.
	 *
	 * @param location The file location where the problem is located.
	 */
	public NonDelimitedStatementException( FileLocation location )
	{
		super( "Non-delimited statement found", location );
	}
}
