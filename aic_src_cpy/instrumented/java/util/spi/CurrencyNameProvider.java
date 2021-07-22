// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.spi;

import instrumented.java.util.List;
import instrumented.java.util.ResourceBundle;
import instrumented.java.util.Locale;
import aic2021.engine.BytecodeManager;

public abstract class CurrencyNameProvider extends LocaleServiceProvider
{
    protected CurrencyNameProvider() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public abstract String getSymbol(final String p0, final Locale p1);
    
    public String getDisplayName(final String s, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            if (s != null) {
                BytecodeManager.incBytecodes(2);
                if (locale != null) {
                    BytecodeManager.incBytecodes(2);
                    final char[] charArray = s.toCharArray();
                    BytecodeManager.incBytecodes(1);
                    final int length = charArray.length;
                    final int n = 3;
                    BytecodeManager.incBytecodes(4);
                    if (length != n) {
                        final String s2 = "The currencyCode is not in the form of three upper-case letters.";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex = new IllegalArgumentException(s2);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final char[] array = charArray;
                    final int length2 = array.length;
                    int n2 = 0;
                    BytecodeManager.incBytecodes(7);
                    Label_0177: {
                        while (true) {
                            final int n3 = n2;
                            final int n4 = length2;
                            BytecodeManager.incBytecodes(3);
                            if (n3 >= n4) {
                                break Label_0177;
                            }
                            final char c = array[n2];
                            BytecodeManager.incBytecodes(4);
                            final char c2 = c;
                            final int n5 = 'A';
                            BytecodeManager.incBytecodes(3);
                            if (c2 < n5) {
                                break;
                            }
                            final char c3 = c;
                            final int n6 = 'Z';
                            BytecodeManager.incBytecodes(3);
                            if (c3 > n6) {
                                break;
                            }
                            ++n2;
                            BytecodeManager.incBytecodes(2);
                        }
                        final String s3 = "The currencyCode is not in the form of three upper-case letters.";
                        BytecodeManager.incBytecodes(4);
                        final IllegalArgumentException ex2 = new IllegalArgumentException(s3);
                        BytecodeManager.incBytecodes(1);
                        throw ex2;
                    }
                    final List<String> format_DEFAULT = ResourceBundle.Control.FORMAT_DEFAULT;
                    BytecodeManager.incBytecodes(2);
                    final ResourceBundle.Control noFallbackControl = ResourceBundle.Control.getNoFallbackControl(format_DEFAULT);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    final Locale[] availableLocales = this.getAvailableLocales();
                    final int length3 = availableLocales.length;
                    int n7 = 0;
                    BytecodeManager.incBytecodes(6);
                    while (true) {
                        final int n8 = n7;
                        final int n9 = length3;
                        BytecodeManager.incBytecodes(3);
                        if (n8 >= n9) {
                            final String s4 = "The locale is not available";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex3 = new IllegalArgumentException(s4);
                            BytecodeManager.incBytecodes(1);
                            throw ex3;
                        }
                        final Locale locale2 = availableLocales[n7];
                        BytecodeManager.incBytecodes(4);
                        final ResourceBundle.Control control = noFallbackControl;
                        final String s5 = "";
                        final Locale locale3 = locale2;
                        BytecodeManager.incBytecodes(4);
                        final List<Locale> candidateLocales = control.getCandidateLocales(s5, locale3);
                        BytecodeManager.incBytecodes(2);
                        final boolean contains = candidateLocales.contains(locale);
                        BytecodeManager.incBytecodes(1);
                        if (contains) {
                            final String s6 = null;
                            BytecodeManager.incBytecodes(2);
                            return s6;
                        }
                        ++n7;
                        BytecodeManager.incBytecodes(2);
                    }
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex4 = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
}
