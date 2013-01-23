/*
 * $Id$
 *
 * Copyright 2013 Valentyn Kolesnikov
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
package com.github.passgen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassGenTest {
    private PassGen passGen;

    @Before
    public void setUp() {
        passGen = new PassGen();
    }

    @Test
    public void generator() throws Exception {
        Method method = passGen.getClass().getDeclaredMethod("jButton29ActionPerformed", new Class[] { java.awt.event.ActionEvent.class });
        method.setAccessible(true);
        method.invoke(passGen, new java.awt.event.ActionEvent("source", 1, "command"));
        Field field = passGen.getClass().getDeclaredField("jTextField1");
        field.setAccessible(true);
        javax.swing.JTextField jTextField1 = (javax.swing.JTextField) field.get(passGen);
        Assert.assertTrue("Password doesn't matches the pattern [A-Z]+[0-9]+.*?[a-z]+ " + jTextField1.getText(),
            jTextField1.getText().matches("[A-Z]+[0-9]+.*?[a-z]+.*"));
    }
}
