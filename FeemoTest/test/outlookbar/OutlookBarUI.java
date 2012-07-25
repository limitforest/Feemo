/**
 * @PROJECT.FULLNAME@ @VERSION@ License.
 *
 * Copyright @YEAR@ L2FProd.com
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
package com.ciotc.feemo.component.outlookbar;

import java.awt.Component;

import javax.swing.JScrollPane;

/**
 * Tagging interface for the JOutlookBar UI.
 *  
 */
public interface OutlookBarUI {

  /**
   * @see com.l2fprod.common.swing.JOutlookBar#makeScrollPane(Component)
   * @param component
   * @return a JScrollPane with <code>component</code> as view
   */
  JScrollPane makeScrollPane(Component component);

}