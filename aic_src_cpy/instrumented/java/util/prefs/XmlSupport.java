// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util.prefs;

import org.xml.sax.SAXParseException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import instrumented.java.util.Set;
import instrumented.java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.EntityResolver;
import org.w3c.dom.DocumentType;
import org.w3c.dom.DOMImplementation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.InputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import instrumented.java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.OutputStream;
import aic2021.engine.BytecodeManager;

class XmlSupport
{
    private static final String PREFS_DTD_URI = "http://java.sun.com/dtd/preferences.dtd";
    private static final String PREFS_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!-- DTD for preferences --><!ELEMENT preferences (root) ><!ATTLIST preferences EXTERNAL_XML_VERSION CDATA \"0.0\"  ><!ELEMENT root (map, node*) ><!ATTLIST root          type (system|user) #REQUIRED ><!ELEMENT node (map, node*) ><!ATTLIST node          name CDATA #REQUIRED ><!ELEMENT map (entry*) ><!ATTLIST map  MAP_XML_VERSION CDATA \"0.0\"  ><!ELEMENT entry EMPTY ><!ATTLIST entry          key CDATA #REQUIRED          value CDATA #REQUIRED >";
    private static final String EXTERNAL_XML_VERSION = "1.0";
    private static final String MAP_XML_VERSION = "1.0";
    
    XmlSupport() {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void export(final OutputStream outputStream, final Preferences preferences, final boolean b) throws IOException, BackingStoreException {
        try {
            final AbstractPreferences abstractPreferences = (AbstractPreferences)preferences;
            BytecodeManager.incBytecodes(3);
            final boolean removed = abstractPreferences.isRemoved();
            BytecodeManager.incBytecodes(1);
            if (removed) {
                final String s = "Node has been removed";
                BytecodeManager.incBytecodes(4);
                final IllegalStateException ex = new IllegalStateException(s);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final String s2 = "preferences";
            BytecodeManager.incBytecodes(2);
            final Document prefsDoc = createPrefsDoc(s2);
            BytecodeManager.incBytecodes(1);
            final Document document = prefsDoc;
            BytecodeManager.incBytecodes(2);
            final Element documentElement = document.getDocumentElement();
            BytecodeManager.incBytecodes(1);
            final Element element = documentElement;
            final String s3 = "EXTERNAL_XML_VERSION";
            final String s4 = "1.0";
            BytecodeManager.incBytecodes(4);
            element.setAttribute(s3, s4);
            final Element element2 = documentElement;
            final Document document2 = prefsDoc;
            final String s5 = "root";
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
            final Element element3 = document2.createElement(s5);
            BytecodeManager.incBytecodes(1);
            final Element element4 = (Element)element2.appendChild(element3);
            BytecodeManager.incBytecodes(2);
            final Element element5 = element4;
            final String s6 = "type";
            BytecodeManager.incBytecodes(4);
            final boolean userNode = preferences.isUserNode();
            BytecodeManager.incBytecodes(1);
            String s7;
            if (userNode) {
                s7 = "user";
                BytecodeManager.incBytecodes(2);
            }
            else {
                s7 = "system";
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            element5.setAttribute(s6, s7);
            BytecodeManager.incBytecodes(3);
            final ArrayList<Preferences> list = new ArrayList<Preferences>();
            BytecodeManager.incBytecodes(1);
            final Preferences preferences3;
            Preferences preferences2 = preferences3 = preferences;
            BytecodeManager.incBytecodes(4);
            Preferences preferences4 = preferences3.parent();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Preferences preferences5 = preferences4;
                BytecodeManager.incBytecodes(2);
                if (preferences5 == null) {
                    break;
                }
                final ArrayList<Preferences> list2 = list;
                final Preferences preferences6 = preferences2;
                BytecodeManager.incBytecodes(3);
                list2.add(preferences6);
                BytecodeManager.incBytecodes(1);
                final Preferences preferences7;
                preferences2 = (preferences7 = preferences4);
                BytecodeManager.incBytecodes(4);
                preferences4 = preferences7.parent();
                BytecodeManager.incBytecodes(2);
            }
            Element element6 = element4;
            BytecodeManager.incBytecodes(2);
            final ArrayList<Preferences> list3 = list;
            BytecodeManager.incBytecodes(2);
            int n = list3.size() - 1;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final int n2 = n;
                BytecodeManager.incBytecodes(2);
                if (n2 < 0) {
                    break;
                }
                final Element element7 = element6;
                final Document document3 = prefsDoc;
                final String s8 = "map";
                BytecodeManager.incBytecodes(4);
                final Element element8 = document3.createElement(s8);
                BytecodeManager.incBytecodes(1);
                element7.appendChild(element8);
                BytecodeManager.incBytecodes(1);
                final Element element9 = element6;
                final Document document4 = prefsDoc;
                final String s9 = "node";
                BytecodeManager.incBytecodes(4);
                final Element element10 = document4.createElement(s9);
                BytecodeManager.incBytecodes(1);
                element6 = (Element)element9.appendChild(element10);
                BytecodeManager.incBytecodes(2);
                final Element element11 = element6;
                final String s10 = "name";
                final ArrayList<Preferences> list4 = list;
                final int n3 = n;
                BytecodeManager.incBytecodes(5);
                final Preferences preferences8 = list4.get(n3);
                BytecodeManager.incBytecodes(2);
                final String name = preferences8.name();
                BytecodeManager.incBytecodes(1);
                element11.setAttribute(s10, name);
                --n;
                BytecodeManager.incBytecodes(2);
            }
            final Element element12 = element6;
            final Document document5 = prefsDoc;
            BytecodeManager.incBytecodes(5);
            putPreferencesInXml(element12, document5, preferences, b);
            final Document document6 = prefsDoc;
            BytecodeManager.incBytecodes(3);
            writeDoc(document6, outputStream);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void putPreferencesInXml(final Element p0, final Document p1, final Preferences p2, final boolean p3) throws BackingStoreException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: ldc             2
        //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     8: aconst_null    
        //     9: astore          5
        //    11: ldc             2
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aload_2        
        //    17: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    20: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    23: dup            
        //    24: astore          6
        //    26: pop            
        //    27: ldc             6
        //    29: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    32: aload_2        
        //    33: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    36: ldc             3
        //    38: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    41: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.isRemoved:()Z
        //    44: ldc             1
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: ifeq            94
        //    52: aload_0        
        //    53: ldc             2
        //    55: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    58: invokeinterface org/w3c/dom/Element.getParentNode:()Lorg/w3c/dom/Node;
        //    63: aload_0        
        //    64: ldc             2
        //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    69: invokeinterface org/w3c/dom/Node.removeChild:(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;
        //    74: pop            
        //    75: ldc             1
        //    77: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    80: aload           6
        //    82: pop            
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: ldc             1
        //    90: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    93: return         
        //    94: aload_2        
        //    95: ldc             2
        //    97: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   100: invokevirtual   instrumented/java/util/prefs/Preferences.keys:()[Ljava/lang/String;
        //   103: astore          7
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: aload_0        
        //   111: aload_1        
        //   112: ldc             "map"
        //   114: ldc             4
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: invokeinterface org/w3c/dom/Document.createElement:(Ljava/lang/String;)Lorg/w3c/dom/Element;
        //   124: ldc             1
        //   126: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   129: invokeinterface org/w3c/dom/Element.appendChild:(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;
        //   134: checkcast       Lorg/w3c/dom/Element;
        //   137: astore          8
        //   139: ldc             2
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: iconst_0       
        //   145: istore          9
        //   147: ldc             2
        //   149: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   152: iload           9
        //   154: aload           7
        //   156: arraylength    
        //   157: ldc             4
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: if_icmpge       264
        //   165: aload           8
        //   167: aload_1        
        //   168: ldc             "entry"
        //   170: ldc             3
        //   172: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   175: ldc             1
        //   177: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   180: invokeinterface org/w3c/dom/Document.createElement:(Ljava/lang/String;)Lorg/w3c/dom/Element;
        //   185: ldc             1
        //   187: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   190: invokeinterface org/w3c/dom/Element.appendChild:(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;
        //   195: checkcast       Lorg/w3c/dom/Element;
        //   198: astore          10
        //   200: ldc             2
        //   202: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   205: aload           10
        //   207: ldc             "key"
        //   209: aload           7
        //   211: iload           9
        //   213: aaload         
        //   214: ldc             6
        //   216: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   219: invokeinterface org/w3c/dom/Element.setAttribute:(Ljava/lang/String;Ljava/lang/String;)V
        //   224: aload           10
        //   226: ldc             "value"
        //   228: aload_2        
        //   229: aload           7
        //   231: iload           9
        //   233: aaload         
        //   234: aconst_null    
        //   235: ldc             8
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: invokevirtual   instrumented/java/util/prefs/Preferences.get:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   243: ldc             1
        //   245: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   248: invokeinterface org/w3c/dom/Element.setAttribute:(Ljava/lang/String;Ljava/lang/String;)V
        //   253: iinc            9, 1
        //   256: ldc             2
        //   258: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   261: goto            152
        //   264: iload_3        
        //   265: ldc             2
        //   267: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   270: ifeq            358
        //   273: aload_2        
        //   274: ldc             2
        //   276: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   279: invokevirtual   instrumented/java/util/prefs/Preferences.childrenNames:()[Ljava/lang/String;
        //   282: astore          5
        //   284: ldc             1
        //   286: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   289: aload           5
        //   291: arraylength    
        //   292: anewarray       Linstrumented/java/util/prefs/Preferences;
        //   295: astore          4
        //   297: ldc             3
        //   299: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   302: iconst_0       
        //   303: istore          9
        //   305: ldc             2
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: iload           9
        //   312: aload           5
        //   314: arraylength    
        //   315: ldc             4
        //   317: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   320: if_icmpge       358
        //   323: aload           4
        //   325: iload           9
        //   327: aload_2        
        //   328: aload           5
        //   330: iload           9
        //   332: aaload         
        //   333: ldc             7
        //   335: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   338: invokevirtual   instrumented/java/util/prefs/Preferences.node:(Ljava/lang/String;)Linstrumented/java/util/prefs/Preferences;
        //   341: aastore        
        //   342: ldc             1
        //   344: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   347: iinc            9, 1
        //   350: ldc             2
        //   352: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   355: goto            310
        //   358: aload           6
        //   360: pop            
        //   361: ldc             2
        //   363: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   366: ldc             1
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: goto            392
        //   374: astore          11
        //   376: aload           6
        //   378: pop            
        //   379: ldc             503
        //   381: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   384: aload           11
        //   386: ldc             2
        //   388: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   391: athrow         
        //   392: iload_3        
        //   393: ldc             2
        //   395: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   398: ifeq            508
        //   401: iconst_0       
        //   402: istore          6
        //   404: ldc             2
        //   406: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   409: iload           6
        //   411: aload           5
        //   413: arraylength    
        //   414: ldc             4
        //   416: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   419: if_icmpge       508
        //   422: aload_0        
        //   423: aload_1        
        //   424: ldc             "node"
        //   426: ldc             3
        //   428: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   431: ldc             1
        //   433: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   436: invokeinterface org/w3c/dom/Document.createElement:(Ljava/lang/String;)Lorg/w3c/dom/Element;
        //   441: ldc             1
        //   443: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   446: invokeinterface org/w3c/dom/Element.appendChild:(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;
        //   451: checkcast       Lorg/w3c/dom/Element;
        //   454: astore          7
        //   456: ldc             2
        //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   461: aload           7
        //   463: ldc             "name"
        //   465: aload           5
        //   467: iload           6
        //   469: aaload         
        //   470: ldc             6
        //   472: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   475: invokeinterface org/w3c/dom/Element.setAttribute:(Ljava/lang/String;Ljava/lang/String;)V
        //   480: aload           7
        //   482: aload_1        
        //   483: aload           4
        //   485: iload           6
        //   487: aaload         
        //   488: iload_3        
        //   489: ldc             7
        //   491: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   494: invokestatic    instrumented/java/util/prefs/XmlSupport.putPreferencesInXml:(Lorg/w3c/dom/Element;Lorg/w3c/dom/Document;Linstrumented/java/util/prefs/Preferences;Z)V
        //   497: iinc            6, 1
        //   500: ldc             2
        //   502: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   505: goto            409
        //   508: ldc             1
        //   510: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   513: return         
        //   514: athrow         
        //   515: athrow         
        //    Exceptions:
        //  throws instrumented.java.util.prefs.BackingStoreException
        //    StackMapTable: 00 0B FE 00 5E 07 00 A5 07 00 A7 07 00 04 FE 00 39 07 00 A7 07 00 4F 01 FA 00 6F FC 00 2D 01 F8 00 2F 4F 07 00 2B FA 00 11 FC 00 10 01 FA 00 62 FF 00 05 00 00 00 01 07 00 2B FF 00 00 00 00 00 01 07 00 95
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  32     515    515    516    Ljava/lang/VirtualMachineError;
        //  32     88     374    392    Any
        //  94     366    374    392    Any
        //  374    384    374    392    Any
        //  0      514    514    515    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static void importPreferences(final InputStream inputStream) throws IOException, InvalidPreferencesFormatException {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Document loadPrefsDoc = loadPrefsDoc(inputStream);
                    BytecodeManager.incBytecodes(1);
                    final Document document = loadPrefsDoc;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Element documentElement = document.getDocumentElement();
                    final String s = "EXTERNAL_XML_VERSION";
                    BytecodeManager.incBytecodes(2);
                    final String attribute = documentElement.getAttribute(s);
                    BytecodeManager.incBytecodes(1);
                    final String s2 = attribute;
                    final String anotherString = "1.0";
                    BytecodeManager.incBytecodes(3);
                    final int compareTo = s2.compareTo(anotherString);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo > 0) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Exported preferences file format version ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String str2 = attribute;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(str2);
                        final String str3 = " is not supported. This java installation can read";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str3);
                        final String str4 = " versions ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(str4);
                        final String str5 = "1.0";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append5 = append4.append(str5);
                        final String str6 = " or older. You may need";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append6 = append5.append(str6);
                        final String str7 = " to install a newer version of JDK.";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append7 = append6.append(str7);
                        BytecodeManager.incBytecodes(1);
                        final String string = append7.toString();
                        BytecodeManager.incBytecodes(1);
                        final InvalidPreferencesFormatException ex = new InvalidPreferencesFormatException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Document document2 = loadPrefsDoc;
                    BytecodeManager.incBytecodes(2);
                    final Element documentElement2 = document2.getDocumentElement();
                    BytecodeManager.incBytecodes(1);
                    final NodeList childNodes = documentElement2.getChildNodes();
                    final int n = 0;
                    BytecodeManager.incBytecodes(2);
                    final Element element = (Element)childNodes.item(n);
                    BytecodeManager.incBytecodes(2);
                    final Element element2 = element;
                    final String s3 = "type";
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                    final String attribute2 = element2.getAttribute(s3);
                    final String anObject = "user";
                    BytecodeManager.incBytecodes(2);
                    final boolean equals = attribute2.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    Preferences preferences;
                    if (equals) {
                        BytecodeManager.incBytecodes(1);
                        preferences = Preferences.userRoot();
                        BytecodeManager.incBytecodes(1);
                    }
                    else {
                        BytecodeManager.incBytecodes(1);
                        preferences = Preferences.systemRoot();
                    }
                    final Preferences preferences2 = preferences;
                    BytecodeManager.incBytecodes(1);
                    final Preferences preferences3 = preferences2;
                    final Element element3 = element;
                    BytecodeManager.incBytecodes(3);
                    ImportSubtree(preferences3, element3);
                    BytecodeManager.incBytecodes(1);
                }
                catch (SAXException ex3) {
                    BytecodeManager.incBytecodes(501);
                    final SAXException ex2 = ex3;
                    BytecodeManager.incBytecodes(4);
                    final InvalidPreferencesFormatException ex4 = new InvalidPreferencesFormatException(ex2);
                    BytecodeManager.incBytecodes(1);
                    throw ex4;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static Document createPrefsDoc(final String s) {
        try {
            try {
                BytecodeManager.incBytecodes(1);
                final DocumentBuilderFactory instance = DocumentBuilderFactory.newInstance();
                BytecodeManager.incBytecodes(1);
                final DocumentBuilder documentBuilder = instance.newDocumentBuilder();
                BytecodeManager.incBytecodes(1);
                final DOMImplementation domImplementation = documentBuilder.getDOMImplementation();
                BytecodeManager.incBytecodes(1);
                final DOMImplementation domImplementation2 = domImplementation;
                final String s2 = null;
                final String s3 = "http://java.sun.com/dtd/preferences.dtd";
                BytecodeManager.incBytecodes(5);
                final DocumentType documentType = domImplementation2.createDocumentType(s, s2, s3);
                BytecodeManager.incBytecodes(1);
                final DOMImplementation domImplementation3 = domImplementation;
                final String s4 = null;
                final DocumentType documentType2 = documentType;
                BytecodeManager.incBytecodes(5);
                final Document document = domImplementation3.createDocument(s4, s, documentType2);
                BytecodeManager.incBytecodes(1);
                return document;
            }
            catch (ParserConfigurationException ex) {
                BytecodeManager.incBytecodes(501);
                final ParserConfigurationException detailMessage = ex;
                BytecodeManager.incBytecodes(4);
                final AssertionError assertionError = new AssertionError((Object)detailMessage);
                BytecodeManager.incBytecodes(1);
                throw assertionError;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static Document loadPrefsDoc(final InputStream inputStream) throws SAXException, IOException {
        DocumentBuilderFactory instance;
        try {
            BytecodeManager.incBytecodes(1);
            instance = DocumentBuilderFactory.newInstance();
            BytecodeManager.incBytecodes(1);
            final DocumentBuilderFactory documentBuilderFactory = instance;
            final boolean ignoringElementContentWhitespace = true;
            BytecodeManager.incBytecodes(3);
            documentBuilderFactory.setIgnoringElementContentWhitespace(ignoringElementContentWhitespace);
            final DocumentBuilderFactory documentBuilderFactory2 = instance;
            final boolean validating = true;
            BytecodeManager.incBytecodes(3);
            documentBuilderFactory2.setValidating(validating);
            final DocumentBuilderFactory documentBuilderFactory3 = instance;
            final boolean coalescing = true;
            BytecodeManager.incBytecodes(3);
            documentBuilderFactory3.setCoalescing(coalescing);
            final DocumentBuilderFactory documentBuilderFactory4 = instance;
            final boolean ignoringComments = true;
            BytecodeManager.incBytecodes(3);
            documentBuilderFactory4.setIgnoringComments(ignoringComments);
            try {
                final DocumentBuilderFactory documentBuilderFactory5 = instance;
                final int n = 2;
                BytecodeManager.incBytecodes(n);
                final DocumentBuilder documentBuilder = documentBuilderFactory5.newDocumentBuilder();
                final int n2 = 1;
                BytecodeManager.incBytecodes(n2);
                final DocumentBuilder documentBuilder2 = documentBuilder;
                final Object object = null;
                final int n3 = 5;
                BytecodeManager.incBytecodes(n3);
                final Resolver resolver = new Resolver();
                final int n4 = 1;
                BytecodeManager.incBytecodes(n4);
                documentBuilder2.setEntityResolver(resolver);
                final DocumentBuilder documentBuilder3 = documentBuilder;
                final Object object2 = null;
                final int n5 = 5;
                BytecodeManager.incBytecodes(n5);
                final EH eh = new EH();
                final int n6 = 1;
                BytecodeManager.incBytecodes(n6);
                documentBuilder3.setErrorHandler(eh);
                final DocumentBuilder documentBuilder4 = documentBuilder;
                final InputStream inputStream2 = inputStream;
                final int n7 = 5;
                BytecodeManager.incBytecodes(n7);
                final InputSource inputSource = new InputSource(inputStream2);
                final int n8 = 1;
                BytecodeManager.incBytecodes(n8);
                final Document document = documentBuilder4.parse(inputSource);
                final int n9 = 1;
                BytecodeManager.incBytecodes(n9);
                return document;
            }
            catch (ParserConfigurationException ex) {
                BytecodeManager.incBytecodes(501);
                final ParserConfigurationException detailMessage = ex;
                BytecodeManager.incBytecodes(4);
                final AssertionError assertionError = new AssertionError((Object)detailMessage);
                BytecodeManager.incBytecodes(1);
                throw assertionError;
            }
        }
        finally {}
        try {
            final DocumentBuilderFactory documentBuilderFactory5 = instance;
            final int n = 2;
            BytecodeManager.incBytecodes(n);
            final DocumentBuilder documentBuilder = documentBuilderFactory5.newDocumentBuilder();
            final int n2 = 1;
            BytecodeManager.incBytecodes(n2);
            final DocumentBuilder documentBuilder2 = documentBuilder;
            final Object object = null;
            final int n3 = 5;
            BytecodeManager.incBytecodes(n3);
            final Resolver resolver = new Resolver();
            final int n4 = 1;
            BytecodeManager.incBytecodes(n4);
            documentBuilder2.setEntityResolver(resolver);
            final DocumentBuilder documentBuilder3 = documentBuilder;
            final Object object2 = null;
            final int n5 = 5;
            BytecodeManager.incBytecodes(n5);
            final EH eh = new EH();
            final int n6 = 1;
            BytecodeManager.incBytecodes(n6);
            documentBuilder3.setErrorHandler(eh);
            final DocumentBuilder documentBuilder4 = documentBuilder;
            final InputStream inputStream2 = inputStream;
            final int n7 = 5;
            BytecodeManager.incBytecodes(n7);
            final InputSource inputSource = new InputSource(inputStream2);
            final int n8 = 1;
            BytecodeManager.incBytecodes(n8);
            final Document document = documentBuilder4.parse(inputSource);
            final int n9 = 1;
            BytecodeManager.incBytecodes(n9);
            return document;
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static final void writeDoc(final Document n, final OutputStream out) throws IOException {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(1);
                    final TransformerFactory instance = TransformerFactory.newInstance();
                    BytecodeManager.incBytecodes(1);
                    try {
                        final TransformerFactory transformerFactory = instance;
                        final String s = "indent-number";
                        final int value = 2;
                        BytecodeManager.incBytecodes(6);
                        final Integer n2 = new Integer(value);
                        BytecodeManager.incBytecodes(1);
                        transformerFactory.setAttribute(s, n2);
                        BytecodeManager.incBytecodes(1);
                    }
                    catch (IllegalArgumentException ex2) {
                        BytecodeManager.incBytecodes(501);
                    }
                    final TransformerFactory transformerFactory2 = instance;
                    BytecodeManager.incBytecodes(2);
                    final Transformer transformer = transformerFactory2.newTransformer();
                    BytecodeManager.incBytecodes(1);
                    final Transformer transformer2 = transformer;
                    final String s2 = "doctype-system";
                    BytecodeManager.incBytecodes(4);
                    final DocumentType doctype = n.getDoctype();
                    BytecodeManager.incBytecodes(1);
                    final String systemId = doctype.getSystemId();
                    BytecodeManager.incBytecodes(1);
                    transformer2.setOutputProperty(s2, systemId);
                    final Transformer transformer3 = transformer;
                    final String s3 = "indent";
                    final String s4 = "yes";
                    BytecodeManager.incBytecodes(4);
                    transformer3.setOutputProperty(s3, s4);
                    final Transformer transformer4 = transformer;
                    BytecodeManager.incBytecodes(5);
                    final DOMSource domSource = new DOMSource(n);
                    final String charsetName = "UTF-8";
                    BytecodeManager.incBytecodes(9);
                    final OutputStreamWriter out2 = new OutputStreamWriter(out, charsetName);
                    BytecodeManager.incBytecodes(1);
                    final BufferedWriter writer = new BufferedWriter(out2);
                    BytecodeManager.incBytecodes(1);
                    final StreamResult streamResult = new StreamResult(writer);
                    BytecodeManager.incBytecodes(1);
                    transformer4.transform(domSource, streamResult);
                    BytecodeManager.incBytecodes(1);
                }
                catch (TransformerException ex) {
                    BytecodeManager.incBytecodes(501);
                    final TransformerException detailMessage = ex;
                    BytecodeManager.incBytecodes(4);
                    final AssertionError assertionError = new AssertionError((Object)detailMessage);
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static void ImportSubtree(final Preferences p0, final Element p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokeinterface org/w3c/dom/Element.getChildNodes:()Lorg/w3c/dom/NodeList;
        //    11: astore_2       
        //    12: ldc             1
        //    14: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    17: aload_2        
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: invokeinterface org/w3c/dom/NodeList.getLength:()I
        //    28: istore_3       
        //    29: ldc             1
        //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    34: aload_0        
        //    35: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    38: getfield        instrumented/java/util/prefs/AbstractPreferences.lock:Ljava/lang/Object;
        //    41: dup            
        //    42: astore          5
        //    44: pop            
        //    45: ldc             6
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: aload_0        
        //    51: checkcast       Linstrumented/java/util/prefs/AbstractPreferences;
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: invokevirtual   instrumented/java/util/prefs/AbstractPreferences.isRemoved:()Z
        //    62: ldc             1
        //    64: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    67: ifeq            84
        //    70: aload           5
        //    72: pop            
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: ldc             1
        //    80: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    83: return         
        //    84: aload_2        
        //    85: iconst_0       
        //    86: ldc             3
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokeinterface org/w3c/dom/NodeList.item:(I)Lorg/w3c/dom/Node;
        //    96: checkcast       Lorg/w3c/dom/Element;
        //    99: astore          6
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: aload_0        
        //   107: aload           6
        //   109: ldc             3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokestatic    instrumented/java/util/prefs/XmlSupport.ImportPrefs:(Linstrumented/java/util/prefs/Preferences;Lorg/w3c/dom/Element;)V
        //   117: iload_3        
        //   118: iconst_1       
        //   119: isub           
        //   120: anewarray       Linstrumented/java/util/prefs/Preferences;
        //   123: astore          4
        //   125: ldc             4
        //   127: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   130: iconst_1       
        //   131: istore          7
        //   133: ldc             2
        //   135: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   138: iload           7
        //   140: iload_3        
        //   141: ldc             3
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: if_icmpge       218
        //   149: aload_2        
        //   150: iload           7
        //   152: ldc             3
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: invokeinterface org/w3c/dom/NodeList.item:(I)Lorg/w3c/dom/Node;
        //   162: checkcast       Lorg/w3c/dom/Element;
        //   165: astore          8
        //   167: ldc             2
        //   169: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   172: aload           4
        //   174: iload           7
        //   176: iconst_1       
        //   177: isub           
        //   178: aload_0        
        //   179: aload           8
        //   181: ldc             "name"
        //   183: ldc             8
        //   185: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   188: invokeinterface org/w3c/dom/Element.getAttribute:(Ljava/lang/String;)Ljava/lang/String;
        //   193: ldc             1
        //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   198: invokevirtual   instrumented/java/util/prefs/Preferences.node:(Ljava/lang/String;)Linstrumented/java/util/prefs/Preferences;
        //   201: aastore        
        //   202: ldc             1
        //   204: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   207: iinc            7, 1
        //   210: ldc             2
        //   212: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   215: goto            138
        //   218: aload           5
        //   220: pop            
        //   221: ldc             2
        //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   226: ldc             1
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: goto            252
        //   234: astore          9
        //   236: aload           5
        //   238: pop            
        //   239: ldc             503
        //   241: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   244: aload           9
        //   246: ldc             2
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: athrow         
        //   252: iconst_1       
        //   253: istore          5
        //   255: ldc             2
        //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   260: iload           5
        //   262: iload_3        
        //   263: ldc             3
        //   265: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   268: if_icmpge       313
        //   271: aload           4
        //   273: iload           5
        //   275: iconst_1       
        //   276: isub           
        //   277: aaload         
        //   278: aload_2        
        //   279: iload           5
        //   281: ldc             8
        //   283: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   286: invokeinterface org/w3c/dom/NodeList.item:(I)Lorg/w3c/dom/Node;
        //   291: checkcast       Lorg/w3c/dom/Element;
        //   294: ldc             2
        //   296: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   299: invokestatic    instrumented/java/util/prefs/XmlSupport.ImportSubtree:(Linstrumented/java/util/prefs/Preferences;Lorg/w3c/dom/Element;)V
        //   302: iinc            5, 1
        //   305: ldc             2
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: goto            260
        //   313: ldc             1
        //   315: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   318: return         
        //   319: athrow         
        //   320: athrow         
        //    StackMapTable: 00 09 FF 00 54 00 06 07 00 61 07 00 4F 07 00 EA 01 00 07 00 04 00 00 FF 00 35 00 08 07 00 61 07 00 4F 07 00 EA 01 07 00 A5 07 00 04 07 00 4F 01 00 00 F9 00 4F FF 00 0F 00 06 07 00 61 07 00 4F 07 00 EA 01 00 07 00 04 00 01 07 00 2B FF 00 11 00 05 07 00 61 07 00 4F 07 00 EA 01 07 00 A5 00 00 FC 00 07 01 FA 00 34 FF 00 05 00 00 00 01 07 00 2B FF 00 00 00 00 00 01 07 00 95
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  50     320    320    321    Ljava/lang/VirtualMachineError;
        //  50     78     234    252    Any
        //  84     226    234    252    Any
        //  234    244    234    252    Any
        //  0      319    319    320    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0084:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void ImportPrefs(final Preferences preferences, final Element element) {
        try {
            BytecodeManager.incBytecodes(2);
            final NodeList childNodes = element.getChildNodes();
            BytecodeManager.incBytecodes(1);
            int n = 0;
            final NodeList list = childNodes;
            BytecodeManager.incBytecodes(4);
            final int length = list.getLength();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final int n2 = n;
                final int n3 = length;
                BytecodeManager.incBytecodes(3);
                if (n2 >= n3) {
                    break;
                }
                final NodeList list2 = childNodes;
                final int n4 = n;
                BytecodeManager.incBytecodes(3);
                final Element element2 = (Element)list2.item(n4);
                BytecodeManager.incBytecodes(2);
                final Element element3 = element2;
                final String s = "key";
                BytecodeManager.incBytecodes(4);
                final String attribute = element3.getAttribute(s);
                final Element element4 = element2;
                final String s2 = "value";
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                final String attribute2 = element4.getAttribute(s2);
                BytecodeManager.incBytecodes(1);
                preferences.put(attribute, attribute2);
                ++n;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void exportMap(final OutputStream outputStream, final Map<String, String> map) throws IOException {
        try {
            final String s = "map";
            BytecodeManager.incBytecodes(2);
            final Document prefsDoc = createPrefsDoc(s);
            BytecodeManager.incBytecodes(1);
            final Document document = prefsDoc;
            BytecodeManager.incBytecodes(2);
            final Element documentElement = document.getDocumentElement();
            BytecodeManager.incBytecodes(1);
            final Element element = documentElement;
            final String s2 = "MAP_XML_VERSION";
            final String s3 = "1.0";
            BytecodeManager.incBytecodes(4);
            element.setAttribute(s2, s3);
            BytecodeManager.incBytecodes(2);
            final Set<Map.Entry<String, String>> entrySet = map.entrySet();
            BytecodeManager.incBytecodes(1);
            final Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<Map.Entry<String, String>> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<Map.Entry<String, String>> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final Map.Entry<String, String> entry = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final Element element2 = documentElement;
                final Document document2 = prefsDoc;
                final String s4 = "entry";
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
                final Element element3 = document2.createElement(s4);
                BytecodeManager.incBytecodes(1);
                final Element element4 = (Element)element2.appendChild(element3);
                BytecodeManager.incBytecodes(2);
                final Element element5 = element4;
                final String s5 = "key";
                final Map.Entry<String, String> entry2 = entry;
                BytecodeManager.incBytecodes(4);
                final String s6 = entry2.getKey();
                BytecodeManager.incBytecodes(2);
                element5.setAttribute(s5, s6);
                final Element element6 = element4;
                final String s7 = "value";
                final Map.Entry<String, String> entry3 = entry;
                BytecodeManager.incBytecodes(4);
                final String s8 = entry3.getValue();
                BytecodeManager.incBytecodes(2);
                element6.setAttribute(s7, s8);
                BytecodeManager.incBytecodes(1);
            }
            final Document document3 = prefsDoc;
            BytecodeManager.incBytecodes(3);
            writeDoc(document3, outputStream);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static void importMap(final InputStream inputStream, final Map<String, String> map) throws IOException, InvalidPreferencesFormatException {
        try {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    final Document loadPrefsDoc = loadPrefsDoc(inputStream);
                    BytecodeManager.incBytecodes(1);
                    final Document document = loadPrefsDoc;
                    BytecodeManager.incBytecodes(2);
                    final Element documentElement = document.getDocumentElement();
                    BytecodeManager.incBytecodes(1);
                    final Element element = documentElement;
                    final String s = "MAP_XML_VERSION";
                    BytecodeManager.incBytecodes(3);
                    final String attribute = element.getAttribute(s);
                    BytecodeManager.incBytecodes(1);
                    final String s2 = attribute;
                    final String anotherString = "1.0";
                    BytecodeManager.incBytecodes(3);
                    final int compareTo = s2.compareTo(anotherString);
                    BytecodeManager.incBytecodes(1);
                    if (compareTo > 0) {
                        BytecodeManager.incBytecodes(5);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "Preferences map file format version ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final String str2 = attribute;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(str2);
                        final String str3 = " is not supported. This java installation can read";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str3);
                        final String str4 = " versions ";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(str4);
                        final String str5 = "1.0";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append5 = append4.append(str5);
                        final String str6 = " or older. You may need";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append6 = append5.append(str6);
                        final String str7 = " to install a newer version of JDK.";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append7 = append6.append(str7);
                        BytecodeManager.incBytecodes(1);
                        final String string = append7.toString();
                        BytecodeManager.incBytecodes(1);
                        final InvalidPreferencesFormatException ex = new InvalidPreferencesFormatException(string);
                        BytecodeManager.incBytecodes(1);
                        throw ex;
                    }
                    final Element element2 = documentElement;
                    BytecodeManager.incBytecodes(2);
                    final NodeList childNodes = element2.getChildNodes();
                    BytecodeManager.incBytecodes(1);
                    int n = 0;
                    final NodeList list = childNodes;
                    BytecodeManager.incBytecodes(4);
                    final int length = list.getLength();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final int n2 = n;
                        final int n3 = length;
                        BytecodeManager.incBytecodes(3);
                        if (n2 >= n3) {
                            break;
                        }
                        final NodeList list2 = childNodes;
                        final int n4 = n;
                        BytecodeManager.incBytecodes(3);
                        final Element element3 = (Element)list2.item(n4);
                        BytecodeManager.incBytecodes(2);
                        final Element element4 = element3;
                        final String s3 = "key";
                        BytecodeManager.incBytecodes(4);
                        final String attribute2 = element4.getAttribute(s3);
                        final Element element5 = element3;
                        final String s4 = "value";
                        BytecodeManager.incBytecodes(3);
                        final String attribute3 = element5.getAttribute(s4);
                        BytecodeManager.incBytecodes(1);
                        map.put(attribute2, attribute3);
                        BytecodeManager.incBytecodes(1);
                        ++n;
                        BytecodeManager.incBytecodes(2);
                    }
                    BytecodeManager.incBytecodes(1);
                }
                catch (SAXException ex3) {
                    BytecodeManager.incBytecodes(501);
                    final SAXException ex2 = ex3;
                    BytecodeManager.incBytecodes(4);
                    final InvalidPreferencesFormatException ex4 = new InvalidPreferencesFormatException(ex2);
                    BytecodeManager.incBytecodes(1);
                    throw ex4;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        catch (VirtualMachineError virtualMachineError) {
            throw virtualMachineError;
        }
    }
    
    private static class Resolver implements EntityResolver
    {
        private Resolver() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public InputSource resolveEntity(final String s, final String str) throws SAXException {
            try {
                final String anObject = "http://java.sun.com/dtd/preferences.dtd";
                BytecodeManager.incBytecodes(3);
                final boolean equals = str.equals(anObject);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    final String s2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!-- DTD for preferences --><!ELEMENT preferences (root) ><!ATTLIST preferences EXTERNAL_XML_VERSION CDATA \"0.0\"  ><!ELEMENT root (map, node*) ><!ATTLIST root          type (system|user) #REQUIRED ><!ELEMENT node (map, node*) ><!ATTLIST node          name CDATA #REQUIRED ><!ELEMENT map (entry*) ><!ATTLIST map  MAP_XML_VERSION CDATA \"0.0\"  ><!ELEMENT entry EMPTY ><!ATTLIST entry          key CDATA #REQUIRED          value CDATA #REQUIRED >";
                    BytecodeManager.incBytecodes(6);
                    final StringReader characterStream = new StringReader(s2);
                    BytecodeManager.incBytecodes(1);
                    final InputSource inputSource = new InputSource(characterStream);
                    BytecodeManager.incBytecodes(1);
                    final InputSource inputSource2 = inputSource;
                    final String systemId = "http://java.sun.com/dtd/preferences.dtd";
                    BytecodeManager.incBytecodes(3);
                    inputSource2.setSystemId(systemId);
                    final InputSource inputSource3 = inputSource;
                    BytecodeManager.incBytecodes(2);
                    return inputSource3;
                }
                BytecodeManager.incBytecodes(5);
                final StringBuilder sb = new StringBuilder();
                final String str2 = "Invalid system identifier: ";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append = sb.append(str2);
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(str);
                BytecodeManager.incBytecodes(1);
                final String string = append2.toString();
                BytecodeManager.incBytecodes(1);
                final SAXException ex = new SAXException(string);
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class EH implements ErrorHandler
    {
        private EH() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void error(final SAXParseException ex) throws SAXException {
            try {
                BytecodeManager.incBytecodes(2);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void fatalError(final SAXParseException ex) throws SAXException {
            try {
                BytecodeManager.incBytecodes(2);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public void warning(final SAXParseException ex) throws SAXException {
            try {
                BytecodeManager.incBytecodes(2);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
