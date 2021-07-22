// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import sun.util.locale.LocaleExtensions;
import sun.util.locale.LocaleObjectCache;
import java.io.IOException;
import sun.util.locale.BaseLocale;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.io.InputStream;
import java.net.URL;
import instrumented.java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;
import aic2021.engine.BytecodeManager;
import instrumented.java.util.spi.ResourceBundleControlProvider;
import java.lang.ref.ReferenceQueue;
import instrumented.java.util.concurrent.ConcurrentMap;

public abstract class ResourceBundle
{
    private static final int INITIAL_CACHE_SIZE = 32;
    private static final ResourceBundle NONEXISTENT_BUNDLE;
    private static final ConcurrentMap<CacheKey, BundleReference> cacheList;
    private static final ReferenceQueue<Object> referenceQueue;
    protected ResourceBundle parent;
    private Locale locale;
    private String name;
    private volatile boolean expired;
    private volatile CacheKey cacheKey;
    private volatile Set<String> keySet;
    private static final List<ResourceBundleControlProvider> providers;
    static final /* synthetic */ boolean $assertionsDisabled;
    
    public String getBaseBundleName() {
        try {
            final String name = this.name;
            BytecodeManager.incBytecodes(3);
            return name;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public ResourceBundle() {
        try {
            BytecodeManager.incBytecodes(2);
            this.parent = null;
            BytecodeManager.incBytecodes(3);
            this.locale = null;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String getString(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final String s2 = (String)this.getObject(s);
            BytecodeManager.incBytecodes(2);
            return s2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final String[] getStringArray(final String s) {
        try {
            BytecodeManager.incBytecodes(3);
            final String[] array = (String[])this.getObject(s);
            BytecodeManager.incBytecodes(3);
            return array;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public final Object getObject(final String str) {
        try {
            BytecodeManager.incBytecodes(3);
            Object o = this.handleGetObject(str);
            BytecodeManager.incBytecodes(1);
            final Object o2 = o;
            BytecodeManager.incBytecodes(2);
            if (o2 == null) {
                final ResourceBundle parent = this.parent;
                BytecodeManager.incBytecodes(3);
                if (parent != null) {
                    final ResourceBundle parent2 = this.parent;
                    BytecodeManager.incBytecodes(4);
                    o = parent2.getObject(str);
                    BytecodeManager.incBytecodes(1);
                }
                final Object o3 = o;
                BytecodeManager.incBytecodes(2);
                if (o3 == null) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str2 = "Can't find resource for bundle ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str2);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends ResourceBundle> class1 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    final String name = class1.getName();
                    BytecodeManager.incBytecodes(1);
                    final StringBuilder append2 = append.append(name);
                    final String str3 = ", key ";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append3 = append2.append(str3);
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append4 = append3.append(str);
                    BytecodeManager.incBytecodes(1);
                    final String string = append4.toString();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    final Class<? extends ResourceBundle> class2 = this.getClass();
                    BytecodeManager.incBytecodes(1);
                    final String name2 = class2.getName();
                    BytecodeManager.incBytecodes(2);
                    final MissingResourceException ex = new MissingResourceException(string, name2, str);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
            }
            final Object o4 = o;
            BytecodeManager.incBytecodes(2);
            return o4;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Locale getLocale() {
        try {
            final Locale locale = this.locale;
            BytecodeManager.incBytecodes(3);
            return locale;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static ClassLoader getLoader(final Class<?> clazz) {
        try {
            BytecodeManager.incBytecodes(2);
            ClassLoader classLoader;
            if (clazz == null) {
                classLoader = null;
                BytecodeManager.incBytecodes(2);
            }
            else {
                BytecodeManager.incBytecodes(2);
                classLoader = clazz.getClassLoader();
            }
            ClassLoader access$000 = classLoader;
            BytecodeManager.incBytecodes(1);
            final ClassLoader classLoader2 = access$000;
            BytecodeManager.incBytecodes(2);
            if (classLoader2 == null) {
                BytecodeManager.incBytecodes(1);
                access$000 = RBClassLoader.access$000();
                BytecodeManager.incBytecodes(1);
            }
            final ClassLoader classLoader3 = access$000;
            BytecodeManager.incBytecodes(2);
            return classLoader3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void setParent(final ResourceBundle parent) {
        try {
            final boolean $assertionsDisabled = ResourceBundle.$assertionsDisabled;
            BytecodeManager.incBytecodes(2);
            if (!$assertionsDisabled) {
                final ResourceBundle nonexistent_BUNDLE = ResourceBundle.NONEXISTENT_BUNDLE;
                BytecodeManager.incBytecodes(3);
                if (parent == nonexistent_BUNDLE) {
                    BytecodeManager.incBytecodes(3);
                    final AssertionError assertionError = new AssertionError();
                    BytecodeManager.incBytecodes(1);
                    throw assertionError;
                }
            }
            this.parent = parent;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static final ResourceBundle getBundle(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            final Locale default1 = Locale.getDefault();
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final ClassLoader loader = getLoader(callerClass);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Control defaultControl = getDefaultControl(s);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle bundleImpl = getBundleImpl(s, default1, loader, defaultControl);
            BytecodeManager.incBytecodes(1);
            return bundleImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static final ResourceBundle getBundle(final String s, final Control control) {
        try {
            BytecodeManager.incBytecodes(2);
            final Locale default1 = Locale.getDefault();
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final ClassLoader loader = getLoader(callerClass);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle bundleImpl = getBundleImpl(s, default1, loader, control);
            BytecodeManager.incBytecodes(1);
            return bundleImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static final ResourceBundle getBundle(final String s, final Locale locale) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final ClassLoader loader = getLoader(callerClass);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Control defaultControl = getDefaultControl(s);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle bundleImpl = getBundleImpl(s, locale, loader, defaultControl);
            BytecodeManager.incBytecodes(1);
            return bundleImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static final ResourceBundle getBundle(final String s, final Locale locale, final Control control) {
        try {
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final ClassLoader loader = getLoader(callerClass);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle bundleImpl = getBundleImpl(s, locale, loader, control);
            BytecodeManager.incBytecodes(1);
            return bundleImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static ResourceBundle getBundle(final String s, final Locale locale, final ClassLoader classLoader) {
        try {
            BytecodeManager.incBytecodes(2);
            if (classLoader == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            BytecodeManager.incBytecodes(5);
            final Control defaultControl = getDefaultControl(s);
            BytecodeManager.incBytecodes(1);
            final ResourceBundle bundleImpl = getBundleImpl(s, locale, classLoader, defaultControl);
            BytecodeManager.incBytecodes(1);
            return bundleImpl;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static ResourceBundle getBundle(final String s, final Locale locale, final ClassLoader classLoader, final Control control) {
        try {
            BytecodeManager.incBytecodes(2);
            if (classLoader != null) {
                BytecodeManager.incBytecodes(2);
                if (control != null) {
                    BytecodeManager.incBytecodes(5);
                    final ResourceBundle bundleImpl = getBundleImpl(s, locale, classLoader, control);
                    BytecodeManager.incBytecodes(1);
                    return bundleImpl;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static Control getDefaultControl(final String s) {
        try {
            final List<ResourceBundleControlProvider> providers = ResourceBundle.providers;
            BytecodeManager.incBytecodes(2);
            if (providers != null) {
                final List<ResourceBundleControlProvider> providers2 = ResourceBundle.providers;
                BytecodeManager.incBytecodes(2);
                final Iterator<ResourceBundleControlProvider> iterator = providers2.iterator();
                BytecodeManager.incBytecodes(1);
                while (true) {
                    final Iterator<ResourceBundleControlProvider> iterator2 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final boolean hasNext = iterator2.hasNext();
                    BytecodeManager.incBytecodes(1);
                    if (!hasNext) {
                        break;
                    }
                    final Iterator<ResourceBundleControlProvider> iterator3 = iterator;
                    BytecodeManager.incBytecodes(2);
                    final ResourceBundleControlProvider resourceBundleControlProvider = iterator3.next();
                    BytecodeManager.incBytecodes(2);
                    final ResourceBundleControlProvider resourceBundleControlProvider2 = resourceBundleControlProvider;
                    BytecodeManager.incBytecodes(3);
                    final Control control = resourceBundleControlProvider2.getControl(s);
                    BytecodeManager.incBytecodes(1);
                    final Control control2 = control;
                    BytecodeManager.incBytecodes(2);
                    if (control2 != null) {
                        final Control control3 = control;
                        BytecodeManager.incBytecodes(2);
                        return control3;
                    }
                    BytecodeManager.incBytecodes(1);
                }
            }
            BytecodeManager.incBytecodes(1);
            final Control access$300 = Control.access$300();
            BytecodeManager.incBytecodes(1);
            return access$300;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static ResourceBundle getBundleImpl(final String s, final Locale locale, final ClassLoader classLoader, final Control control) {
        try {
            BytecodeManager.incBytecodes(2);
            if (locale != null) {
                BytecodeManager.incBytecodes(2);
                if (control != null) {
                    BytecodeManager.incBytecodes(6);
                    final CacheKey cacheKey = new CacheKey(s, locale, classLoader);
                    BytecodeManager.incBytecodes(1);
                    ResourceBundle bundle = null;
                    BytecodeManager.incBytecodes(2);
                    final ConcurrentMap<CacheKey, BundleReference> cacheList = ResourceBundle.cacheList;
                    final CacheKey cacheKey2 = cacheKey;
                    BytecodeManager.incBytecodes(3);
                    final BundleReference bundleReference = cacheList.get(cacheKey2);
                    BytecodeManager.incBytecodes(2);
                    final BundleReference bundleReference2 = bundleReference;
                    BytecodeManager.incBytecodes(2);
                    if (bundleReference2 != null) {
                        final BundleReference bundleReference3 = bundleReference;
                        BytecodeManager.incBytecodes(2);
                        bundle = bundleReference3.get();
                        BytecodeManager.incBytecodes(2);
                        BytecodeManager.incBytecodes(2);
                    }
                    final ResourceBundle resourceBundle = bundle;
                    BytecodeManager.incBytecodes(2);
                    final boolean validBundle = isValidBundle(resourceBundle);
                    BytecodeManager.incBytecodes(1);
                    if (validBundle) {
                        final ResourceBundle resourceBundle2 = bundle;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasValidParentChain = hasValidParentChain(resourceBundle2);
                        BytecodeManager.incBytecodes(1);
                        if (hasValidParentChain) {
                            final ResourceBundle resourceBundle3 = bundle;
                            BytecodeManager.incBytecodes(2);
                            return resourceBundle3;
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final Control access$300 = Control.access$300();
                    BytecodeManager.incBytecodes(1);
                    int n = 0;
                    Label_0217: {
                        if (control != access$300) {
                            final boolean b = control instanceof SingleFormatControl;
                            BytecodeManager.incBytecodes(3);
                            if (!b) {
                                n = 0;
                                BytecodeManager.incBytecodes(1);
                                break Label_0217;
                            }
                        }
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    final boolean b2 = n != 0;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    final List<String> formats = control.getFormats(s);
                    BytecodeManager.incBytecodes(1);
                    final boolean b3 = b2;
                    BytecodeManager.incBytecodes(2);
                    if (!b3) {
                        final List<String> list = formats;
                        BytecodeManager.incBytecodes(2);
                        final boolean checkList = checkList(list);
                        BytecodeManager.incBytecodes(1);
                        if (!checkList) {
                            final String s2 = "Invalid Control: getFormats";
                            BytecodeManager.incBytecodes(4);
                            final IllegalArgumentException ex = new IllegalArgumentException(s2);
                            BytecodeManager.incBytecodes(1);
                            throw ex;
                        }
                    }
                    ResourceBundle resourceBundle4 = null;
                    BytecodeManager.incBytecodes(2);
                    Locale fallbackLocale = locale;
                    BytecodeManager.incBytecodes(2);
                    while (true) {
                        final Locale locale2 = fallbackLocale;
                        BytecodeManager.incBytecodes(2);
                        if (locale2 == null) {
                            break;
                        }
                        final Locale locale3 = fallbackLocale;
                        BytecodeManager.incBytecodes(4);
                        final List<Locale> candidateLocales = control.getCandidateLocales(s, locale3);
                        BytecodeManager.incBytecodes(1);
                        final boolean b4 = b2;
                        BytecodeManager.incBytecodes(2);
                        if (!b4) {
                            final List<Locale> list2 = candidateLocales;
                            BytecodeManager.incBytecodes(2);
                            final boolean checkList2 = checkList(list2);
                            BytecodeManager.incBytecodes(1);
                            if (!checkList2) {
                                final String s3 = "Invalid Control: getCandidateLocales";
                                BytecodeManager.incBytecodes(4);
                                final IllegalArgumentException ex2 = new IllegalArgumentException(s3);
                                BytecodeManager.incBytecodes(1);
                                throw ex2;
                            }
                        }
                        final CacheKey cacheKey3 = cacheKey;
                        final List<Locale> list3 = candidateLocales;
                        final List<String> list4 = formats;
                        final int n2 = 0;
                        final ResourceBundle resourceBundle5 = resourceBundle4;
                        BytecodeManager.incBytecodes(7);
                        bundle = findBundle(cacheKey3, list3, list4, n2, control, resourceBundle5);
                        BytecodeManager.incBytecodes(1);
                        final ResourceBundle resourceBundle6 = bundle;
                        BytecodeManager.incBytecodes(2);
                        final boolean validBundle2 = isValidBundle(resourceBundle6);
                        BytecodeManager.incBytecodes(1);
                        if (validBundle2) {
                            final Locale root = Locale.ROOT;
                            final Locale locale4 = bundle.locale;
                            BytecodeManager.incBytecodes(4);
                            final boolean equals = root.equals(locale4);
                            BytecodeManager.incBytecodes(1);
                            final boolean b5 = equals;
                            BytecodeManager.incBytecodes(2);
                            if (!b5) {
                                break;
                            }
                            final Locale locale5 = bundle.locale;
                            BytecodeManager.incBytecodes(4);
                            final boolean equals2 = locale5.equals(locale);
                            BytecodeManager.incBytecodes(1);
                            if (equals2) {
                                break;
                            }
                            final List<Locale> list5 = candidateLocales;
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                            final int size = list5.size();
                            final int n3 = 1;
                            BytecodeManager.incBytecodes(2);
                            if (size == n3) {
                                final Locale locale6 = bundle.locale;
                                final List<Locale> list6 = candidateLocales;
                                final int n4 = 0;
                                BytecodeManager.incBytecodes(4);
                                BytecodeManager.incBytecodes(1);
                                final Locale value = list6.get(n4);
                                BytecodeManager.incBytecodes(1);
                                final boolean equals3 = locale6.equals(value);
                                BytecodeManager.incBytecodes(1);
                                if (equals3) {
                                    BytecodeManager.incBytecodes(1);
                                    break;
                                }
                            }
                            final boolean b6 = equals;
                            BytecodeManager.incBytecodes(2);
                            if (b6) {
                                final ResourceBundle resourceBundle7 = resourceBundle4;
                                BytecodeManager.incBytecodes(2);
                                if (resourceBundle7 == null) {
                                    resourceBundle4 = bundle;
                                    BytecodeManager.incBytecodes(2);
                                }
                            }
                        }
                        final Locale locale7 = fallbackLocale;
                        BytecodeManager.incBytecodes(4);
                        fallbackLocale = control.getFallbackLocale(s, locale7);
                        BytecodeManager.incBytecodes(2);
                    }
                    final ResourceBundle resourceBundle8 = bundle;
                    BytecodeManager.incBytecodes(2);
                    if (resourceBundle8 == null) {
                        final ResourceBundle resourceBundle9 = resourceBundle4;
                        BytecodeManager.incBytecodes(2);
                        if (resourceBundle9 == null) {
                            final CacheKey cacheKey4 = cacheKey;
                            BytecodeManager.incBytecodes(4);
                            final Throwable access$301 = CacheKey.access$400(cacheKey4);
                            BytecodeManager.incBytecodes(1);
                            throwMissingResourceException(s, locale, access$301);
                        }
                        bundle = resourceBundle4;
                        BytecodeManager.incBytecodes(2);
                    }
                    final ResourceBundle resourceBundle10 = bundle;
                    BytecodeManager.incBytecodes(2);
                    return resourceBundle10;
                }
            }
            BytecodeManager.incBytecodes(3);
            final NullPointerException ex3 = new NullPointerException();
            BytecodeManager.incBytecodes(1);
            throw ex3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean checkList(final List<?> list) {
        try {
            BytecodeManager.incBytecodes(2);
            int n = 0;
            Label_0043: {
                if (list != null) {
                    BytecodeManager.incBytecodes(2);
                    final boolean empty = list.isEmpty();
                    BytecodeManager.incBytecodes(1);
                    if (!empty) {
                        n = 1;
                        BytecodeManager.incBytecodes(2);
                        break Label_0043;
                    }
                }
                n = 0;
                BytecodeManager.incBytecodes(1);
            }
            int n2 = n;
            BytecodeManager.incBytecodes(1);
            final int n3 = n2;
            BytecodeManager.incBytecodes(2);
            if (n3 != 0) {
                BytecodeManager.incBytecodes(2);
                final int size = list.size();
                BytecodeManager.incBytecodes(1);
                int n4 = 0;
                BytecodeManager.incBytecodes(2);
                while (true) {
                    final int n5 = n2;
                    BytecodeManager.incBytecodes(2);
                    if (n5 == 0) {
                        break;
                    }
                    final int n6 = n4;
                    final int n7 = size;
                    BytecodeManager.incBytecodes(3);
                    if (n6 >= n7) {
                        break;
                    }
                    final int n8 = n4;
                    BytecodeManager.incBytecodes(3);
                    final Object value = list.get(n8);
                    BytecodeManager.incBytecodes(1);
                    int n9;
                    if (value != null) {
                        n9 = 1;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        n9 = 0;
                        BytecodeManager.incBytecodes(1);
                    }
                    n2 = n9;
                    BytecodeManager.incBytecodes(1);
                    ++n4;
                    BytecodeManager.incBytecodes(2);
                }
            }
            final int n10 = n2;
            BytecodeManager.incBytecodes(2);
            return n10 != 0;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static ResourceBundle findBundle(final CacheKey p0, final List<Locale> p1, final List<String> p2, final int p3, final Control p4, final ResourceBundle p5) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_3        
        //     2: ldc             3
        //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     7: invokeinterface instrumented/java/util/List.get:(I)Ljava/lang/Object;
        //    12: checkcast       Linstrumented/java/util/Locale;
        //    15: astore          6
        //    17: ldc             2
        //    19: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    22: aconst_null    
        //    23: astore          7
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: iload_3        
        //    31: aload_1        
        //    32: ldc             3
        //    34: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    37: invokeinterface instrumented/java/util/List.size:()I
        //    42: iconst_1       
        //    43: isub           
        //    44: ldc             3
        //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    49: if_icmpeq       81
        //    52: aload_0        
        //    53: aload_1        
        //    54: aload_2        
        //    55: iload_3        
        //    56: iconst_1       
        //    57: iadd           
        //    58: aload           4
        //    60: aload           5
        //    62: ldc_w           9
        //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    68: invokestatic    instrumented/java/util/ResourceBundle.findBundle:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/List;Linstrumented/java/util/List;ILinstrumented/java/util/ResourceBundle$Control;Linstrumented/java/util/ResourceBundle;)Linstrumented/java/util/ResourceBundle;
        //    71: astore          7
        //    73: ldc             2
        //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    78: goto            120
        //    81: aload           5
        //    83: ldc             2
        //    85: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    88: ifnull          120
        //    91: getstatic       instrumented/java/util/Locale.ROOT:Linstrumented/java/util/Locale;
        //    94: aload           6
        //    96: ldc             3
        //    98: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   101: invokevirtual   instrumented/java/util/Locale.equals:(Ljava/lang/Object;)Z
        //   104: ldc             1
        //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   109: ifeq            120
        //   112: aload           5
        //   114: ldc             2
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: areturn        
        //   120: getstatic       instrumented/java/util/ResourceBundle.referenceQueue:Ljava/lang/ref/ReferenceQueue;
        //   123: ldc             2
        //   125: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   128: invokevirtual   java/lang/ref/ReferenceQueue.poll:()Ljava/lang/ref/Reference;
        //   131: dup            
        //   132: astore          8
        //   134: ldc             3
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: ifnull          179
        //   142: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   145: aload           8
        //   147: checkcast       Linstrumented/java/util/ResourceBundle$CacheKeyReference;
        //   150: ldc             4
        //   152: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   155: invokeinterface instrumented/java/util/ResourceBundle$CacheKeyReference.getCacheKey:()Linstrumented/java/util/ResourceBundle$CacheKey;
        //   160: ldc             1
        //   162: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   165: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   170: pop            
        //   171: ldc             2
        //   173: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   176: goto            120
        //   179: iconst_0       
        //   180: istore          9
        //   182: ldc             2
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: aload_0        
        //   188: aload           6
        //   190: ldc             3
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.setLocale:(Linstrumented/java/util/Locale;)Linstrumented/java/util/ResourceBundle$CacheKey;
        //   198: pop            
        //   199: ldc             1
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: aload_0        
        //   205: aload           4
        //   207: ldc             3
        //   209: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   212: invokestatic    instrumented/java/util/ResourceBundle.findBundleInCache:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/ResourceBundle$Control;)Linstrumented/java/util/ResourceBundle;
        //   215: astore          10
        //   217: ldc             1
        //   219: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   222: aload           10
        //   224: ldc             2
        //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   229: invokestatic    instrumented/java/util/ResourceBundle.isValidBundle:(Linstrumented/java/util/ResourceBundle;)Z
        //   232: ldc             1
        //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   237: ifeq            361
        //   240: aload           10
        //   242: getfield        instrumented/java/util/ResourceBundle.expired:Z
        //   245: istore          9
        //   247: ldc             3
        //   249: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   252: iload           9
        //   254: ldc             2
        //   256: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   259: ifne            361
        //   262: aload           10
        //   264: getfield        instrumented/java/util/ResourceBundle.parent:Linstrumented/java/util/ResourceBundle;
        //   267: aload           7
        //   269: ldc             4
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: if_acmpne       285
        //   277: aload           10
        //   279: ldc             2
        //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   284: areturn        
        //   285: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   288: aload_0        
        //   289: ldc             3
        //   291: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   294: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   299: checkcast       Linstrumented/java/util/ResourceBundle$BundleReference;
        //   302: astore          11
        //   304: ldc             2
        //   306: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   309: aload           11
        //   311: ldc             2
        //   313: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   316: ifnull          361
        //   319: aload           11
        //   321: ldc             2
        //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   326: invokevirtual   instrumented/java/util/ResourceBundle$BundleReference.get:()Ljava/lang/Object;
        //   329: aload           10
        //   331: ldc             2
        //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   336: if_acmpne       361
        //   339: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   342: aload_0        
        //   343: aload           11
        //   345: ldc             4
        //   347: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   350: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.remove:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   355: pop            
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: aload           10
        //   363: getstatic       instrumented/java/util/ResourceBundle.NONEXISTENT_BUNDLE:Linstrumented/java/util/ResourceBundle;
        //   366: ldc             3
        //   368: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   371: if_acmpeq       653
        //   374: aload_0        
        //   375: ldc             2
        //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   380: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.clone:()Ljava/lang/Object;
        //   383: checkcast       Linstrumented/java/util/ResourceBundle$CacheKey;
        //   386: astore          11
        //   388: ldc             2
        //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   393: aload_0        
        //   394: aload_2        
        //   395: aload           4
        //   397: iload           9
        //   399: ldc             5
        //   401: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   404: invokestatic    instrumented/java/util/ResourceBundle.loadBundle:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/List;Linstrumented/java/util/ResourceBundle$Control;Z)Linstrumented/java/util/ResourceBundle;
        //   407: astore          10
        //   409: ldc             1
        //   411: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   414: aload           10
        //   416: ldc             2
        //   418: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   421: ifnull          535
        //   424: aload           10
        //   426: getfield        instrumented/java/util/ResourceBundle.parent:Linstrumented/java/util/ResourceBundle;
        //   429: ldc             3
        //   431: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   434: ifnonnull       449
        //   437: aload           10
        //   439: aload           7
        //   441: ldc             3
        //   443: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   446: invokevirtual   instrumented/java/util/ResourceBundle.setParent:(Linstrumented/java/util/ResourceBundle;)V
        //   449: aload           10
        //   451: aload           6
        //   453: putfield        instrumented/java/util/ResourceBundle.locale:Linstrumented/java/util/Locale;
        //   456: ldc             3
        //   458: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   461: aload_0        
        //   462: aload           10
        //   464: aload           4
        //   466: ldc             4
        //   468: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   471: invokestatic    instrumented/java/util/ResourceBundle.putBundleInCache:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/ResourceBundle;Linstrumented/java/util/ResourceBundle$Control;)Linstrumented/java/util/ResourceBundle;
        //   474: astore          10
        //   476: ldc             1
        //   478: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   481: aload           10
        //   483: astore          12
        //   485: ldc             2
        //   487: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   490: aload           11
        //   492: ldc             2
        //   494: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   497: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$400:(Linstrumented/java/util/ResourceBundle$CacheKey;)Ljava/lang/Throwable;
        //   500: instanceof      Ljava/lang/InterruptedException;
        //   503: ldc             2
        //   505: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   508: ifeq            527
        //   511: ldc             1
        //   513: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   516: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   519: ldc             1
        //   521: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   524: invokevirtual   java/lang/Thread.interrupt:()V
        //   527: aload           12
        //   529: ldc             2
        //   531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   534: areturn        
        //   535: aload_0        
        //   536: getstatic       instrumented/java/util/ResourceBundle.NONEXISTENT_BUNDLE:Linstrumented/java/util/ResourceBundle;
        //   539: aload           4
        //   541: ldc             4
        //   543: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   546: invokestatic    instrumented/java/util/ResourceBundle.putBundleInCache:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/ResourceBundle;Linstrumented/java/util/ResourceBundle$Control;)Linstrumented/java/util/ResourceBundle;
        //   549: pop            
        //   550: ldc             1
        //   552: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   555: aload           11
        //   557: ldc             2
        //   559: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   562: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$400:(Linstrumented/java/util/ResourceBundle$CacheKey;)Ljava/lang/Throwable;
        //   565: instanceof      Ljava/lang/InterruptedException;
        //   568: ldc             2
        //   570: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   573: ifeq            653
        //   576: ldc             1
        //   578: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   581: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   584: ldc             1
        //   586: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   589: invokevirtual   java/lang/Thread.interrupt:()V
        //   592: ldc             1
        //   594: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   597: goto            653
        //   600: astore          13
        //   602: ldc_w           501
        //   605: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   608: aload           11
        //   610: ldc             2
        //   612: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   615: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$400:(Linstrumented/java/util/ResourceBundle$CacheKey;)Ljava/lang/Throwable;
        //   618: instanceof      Ljava/lang/InterruptedException;
        //   621: ldc             2
        //   623: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   626: ifeq            645
        //   629: ldc             1
        //   631: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   634: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   637: ldc             1
        //   639: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   642: invokevirtual   java/lang/Thread.interrupt:()V
        //   645: aload           13
        //   647: ldc             2
        //   649: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   652: athrow         
        //   653: aload           7
        //   655: ldc             2
        //   657: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   660: areturn        
        //   661: athrow         
        //   662: athrow         
        //    Signature:
        //  (Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/List<Linstrumented/java/util/Locale;>;Linstrumented/java/util/List<Ljava/lang/String;>;ILinstrumented/java/util/ResourceBundle$Control;Linstrumented/java/util/ResourceBundle;)Linstrumented/java/util/ResourceBundle;
        //    StackMapTable: 00 0D FD 00 51 07 00 9A 07 00 02 26 FC 00 3A 07 00 04 FD 00 69 01 07 00 02 FB 00 4B FC 00 57 07 00 0C FC 00 4D 07 00 02 FA 00 07 F7 00 40 07 00 47 FD 00 2C 00 07 00 47 F8 00 07 FF 00 07 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 01 1C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  393    662    662    663    Ljava/lang/VirtualMachineError;
        //  393    490    600    653    Any
        //  535    555    600    653    Any
        //  600    608    600    653    Any
        //  0      661    661    662    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0449:
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
    
    private static ResourceBundle loadBundle(final CacheKey p0, final List<String> p1, final Control p2, final boolean p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             2
        //     3: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     6: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getLocale:()Linstrumented/java/util/Locale;
        //     9: astore          4
        //    11: ldc             1
        //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    16: aconst_null    
        //    17: astore          5
        //    19: ldc             2
        //    21: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    24: aload_1        
        //    25: ldc             2
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: invokeinterface instrumented/java/util/List.size:()I
        //    35: istore          6
        //    37: ldc             1
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: iconst_0       
        //    43: istore          7
        //    45: ldc             2
        //    47: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    50: iload           7
        //    52: iload           6
        //    54: ldc             3
        //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    59: if_icmpge       270
        //    62: aload_1        
        //    63: iload           7
        //    65: ldc             3
        //    67: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    70: invokeinterface instrumented/java/util/List.get:(I)Ljava/lang/Object;
        //    75: checkcast       Ljava/lang/String;
        //    78: astore          8
        //    80: ldc             2
        //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    85: aload_2        
        //    86: aload_0        
        //    87: ldc             3
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getName:()Ljava/lang/String;
        //    95: aload           4
        //    97: aload           8
        //    99: aload_0        
        //   100: ldc             3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: ldc             1
        //   107: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   110: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getLoader:()Ljava/lang/ClassLoader;
        //   113: iload_3        
        //   114: ldc             1
        //   116: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   119: ldc             1
        //   121: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   124: invokevirtual   instrumented/java/util/ResourceBundle$Control.newBundle:(Ljava/lang/String;Linstrumented/java/util/Locale;Ljava/lang/String;Ljava/lang/ClassLoader;Z)Linstrumented/java/util/ResourceBundle;
        //   127: astore          5
        //   129: ldc             1
        //   131: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   134: ldc             1
        //   136: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   139: goto            188
        //   142: astore          9
        //   144: ldc_w           501
        //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   150: aload_0        
        //   151: aload           9
        //   153: ldc             3
        //   155: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   158: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$500:(Linstrumented/java/util/ResourceBundle$CacheKey;Ljava/lang/Throwable;)V
        //   161: ldc             1
        //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   166: goto            188
        //   169: astore          9
        //   171: ldc_w           501
        //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   177: aload_0        
        //   178: aload           9
        //   180: ldc             3
        //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   185: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$500:(Linstrumented/java/util/ResourceBundle$CacheKey;Ljava/lang/Throwable;)V
        //   188: aload           5
        //   190: ldc             2
        //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   195: ifnull          259
        //   198: aload_0        
        //   199: aload           8
        //   201: ldc             3
        //   203: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   206: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.setFormat:(Ljava/lang/String;)V
        //   209: aload           5
        //   211: aload_0        
        //   212: ldc             3
        //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   217: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getName:()Ljava/lang/String;
        //   220: putfield        instrumented/java/util/ResourceBundle.name:Ljava/lang/String;
        //   223: ldc             1
        //   225: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   228: aload           5
        //   230: aload           4
        //   232: putfield        instrumented/java/util/ResourceBundle.locale:Linstrumented/java/util/Locale;
        //   235: ldc             3
        //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   240: aload           5
        //   242: iconst_0       
        //   243: putfield        instrumented/java/util/ResourceBundle.expired:Z
        //   246: ldc             3
        //   248: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   251: ldc             1
        //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   256: goto            270
        //   259: iinc            7, 1
        //   262: ldc             2
        //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   267: goto            50
        //   270: aload           5
        //   272: ldc             2
        //   274: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   277: areturn        
        //   278: athrow         
        //   279: athrow         
        //    Signature:
        //  (Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/List<Ljava/lang/String;>;Linstrumented/java/util/ResourceBundle$Control;Z)Linstrumented/java/util/ResourceBundle;
        //    StackMapTable: 00 08 FF 00 32 00 08 07 00 0C 07 00 B7 07 00 12 01 07 00 9A 07 00 02 01 01 00 00 FF 00 5B 00 09 07 00 0C 07 00 B7 07 00 12 01 07 00 9A 07 00 02 01 01 07 00 59 00 01 07 01 54 5A 07 01 56 12 FA 00 46 FA 00 0A FF 00 07 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 01 1C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  85     279    279    280    Ljava/lang/VirtualMachineError;
        //  85     134    142    169    Ljava/lang/LinkageError;
        //  85     134    169    188    Ljava/lang/Exception;
        //  0      278    278    279    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0188:
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
    
    private static boolean isValidBundle(final ResourceBundle resourceBundle) {
        try {
            BytecodeManager.incBytecodes(2);
            boolean b = false;
            Label_0036: {
                if (resourceBundle != null) {
                    final ResourceBundle nonexistent_BUNDLE = ResourceBundle.NONEXISTENT_BUNDLE;
                    BytecodeManager.incBytecodes(3);
                    if (resourceBundle != nonexistent_BUNDLE) {
                        b = true;
                        BytecodeManager.incBytecodes(2);
                        break Label_0036;
                    }
                }
                b = false;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static boolean hasValidParentChain(ResourceBundle parent) {
        try {
            BytecodeManager.incBytecodes(1);
            final long currentTimeMillis = System.currentTimeMillis();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final ResourceBundle resourceBundle = parent;
                BytecodeManager.incBytecodes(2);
                if (resourceBundle == null) {
                    final boolean b = true;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final boolean expired = parent.expired;
                BytecodeManager.incBytecodes(3);
                if (expired) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final CacheKey cacheKey = parent.cacheKey;
                BytecodeManager.incBytecodes(3);
                final CacheKey cacheKey2 = cacheKey;
                BytecodeManager.incBytecodes(2);
                if (cacheKey2 != null) {
                    final CacheKey cacheKey3 = cacheKey;
                    BytecodeManager.incBytecodes(2);
                    final long access$600 = CacheKey.access$600(cacheKey3);
                    BytecodeManager.incBytecodes(1);
                    final long n = lcmp(access$600, 0L);
                    BytecodeManager.incBytecodes(4);
                    if (n >= 0) {
                        final long n2 = lcmp(access$600, currentTimeMillis);
                        BytecodeManager.incBytecodes(4);
                        if (n2 <= 0) {
                            final boolean b3 = false;
                            BytecodeManager.incBytecodes(2);
                            return b3;
                        }
                    }
                }
                parent = parent.parent;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void throwMissingResourceException(final String s, final Locale locale, Throwable t) {
        try {
            final boolean b = t instanceof MissingResourceException;
            BytecodeManager.incBytecodes(3);
            if (b) {
                t = null;
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(5);
            final StringBuilder sb = new StringBuilder();
            final String str = "Can't find bundle for base name ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append = sb.append(str);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append2 = append.append(s);
            final String str2 = ", locale ";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append3 = append2.append(str2);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append4 = append3.append(locale);
            BytecodeManager.incBytecodes(1);
            final String string = append4.toString();
            BytecodeManager.incBytecodes(3);
            final StringBuilder sb2 = new StringBuilder();
            BytecodeManager.incBytecodes(2);
            final StringBuilder append5 = sb2.append(s);
            final String str3 = "_";
            BytecodeManager.incBytecodes(2);
            final StringBuilder append6 = append5.append(str3);
            BytecodeManager.incBytecodes(2);
            final StringBuilder append7 = append6.append(locale);
            BytecodeManager.incBytecodes(1);
            final String string2 = append7.toString();
            final String s2 = "";
            final Throwable t2 = t;
            BytecodeManager.incBytecodes(3);
            final MissingResourceException ex = new MissingResourceException(string, string2, s2, t2);
            BytecodeManager.incBytecodes(1);
            throw ex;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static ResourceBundle findBundleInCache(final CacheKey p0, final Control p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0        
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    14: checkcast       Linstrumented/java/util/ResourceBundle$BundleReference;
        //    17: astore_2       
        //    18: ldc             2
        //    20: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    23: aload_2        
        //    24: ldc             2
        //    26: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    29: ifnonnull       39
        //    32: aconst_null    
        //    33: ldc             2
        //    35: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    38: areturn        
        //    39: aload_2        
        //    40: ldc             2
        //    42: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    45: invokevirtual   instrumented/java/util/ResourceBundle$BundleReference.get:()Ljava/lang/Object;
        //    48: checkcast       Linstrumented/java/util/ResourceBundle;
        //    51: astore_3       
        //    52: ldc             2
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: aload_3        
        //    58: ldc             2
        //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    63: ifnonnull       73
        //    66: aconst_null    
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: areturn        
        //    73: aload_3        
        //    74: getfield        instrumented/java/util/ResourceBundle.parent:Linstrumented/java/util/ResourceBundle;
        //    77: astore          4
        //    79: ldc             3
        //    81: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    84: getstatic       instrumented/java/util/ResourceBundle.$assertionsDisabled:Z
        //    87: ldc             2
        //    89: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    92: ifne            126
        //    95: aload           4
        //    97: getstatic       instrumented/java/util/ResourceBundle.NONEXISTENT_BUNDLE:Linstrumented/java/util/ResourceBundle;
        //   100: ldc             3
        //   102: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   105: if_acmpne       126
        //   108: new             Ljava/lang/AssertionError;
        //   111: dup            
        //   112: ldc             3
        //   114: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   117: invokespecial   java/lang/AssertionError.<init>:()V
        //   120: ldc             1
        //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   125: athrow         
        //   126: aload           4
        //   128: ldc             2
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: ifnull          241
        //   136: aload           4
        //   138: getfield        instrumented/java/util/ResourceBundle.expired:Z
        //   141: ldc             3
        //   143: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   146: ifeq            241
        //   149: getstatic       instrumented/java/util/ResourceBundle.$assertionsDisabled:Z
        //   152: ldc             2
        //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   157: ifne            190
        //   160: aload_3        
        //   161: getstatic       instrumented/java/util/ResourceBundle.NONEXISTENT_BUNDLE:Linstrumented/java/util/ResourceBundle;
        //   164: ldc             3
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: if_acmpne       190
        //   172: new             Ljava/lang/AssertionError;
        //   175: dup            
        //   176: ldc             3
        //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   181: invokespecial   java/lang/AssertionError.<init>:()V
        //   184: ldc             1
        //   186: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   189: athrow         
        //   190: aload_3        
        //   191: iconst_1       
        //   192: putfield        instrumented/java/util/ResourceBundle.expired:Z
        //   195: ldc             3
        //   197: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   200: aload_3        
        //   201: aconst_null    
        //   202: putfield        instrumented/java/util/ResourceBundle.cacheKey:Linstrumented/java/util/ResourceBundle$CacheKey;
        //   205: ldc             3
        //   207: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   210: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   213: aload_0        
        //   214: aload_2        
        //   215: ldc             4
        //   217: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   220: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.remove:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   225: pop            
        //   226: ldc             1
        //   228: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   231: aconst_null    
        //   232: astore_3       
        //   233: ldc             3
        //   235: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   238: goto            653
        //   241: aload_2        
        //   242: ldc             2
        //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   247: invokevirtual   instrumented/java/util/ResourceBundle$BundleReference.getCacheKey:()Linstrumented/java/util/ResourceBundle$CacheKey;
        //   250: astore          5
        //   252: ldc             1
        //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   257: aload           5
        //   259: ldc             2
        //   261: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   264: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$600:(Linstrumented/java/util/ResourceBundle$CacheKey;)J
        //   267: lstore          6
        //   269: ldc             1
        //   271: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   274: aload_3        
        //   275: getfield        instrumented/java/util/ResourceBundle.expired:Z
        //   278: ldc             3
        //   280: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   283: ifne            653
        //   286: lload           6
        //   288: lconst_0       
        //   289: lcmp           
        //   290: ldc             4
        //   292: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   295: iflt            653
        //   298: lload           6
        //   300: ldc             1
        //   302: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   305: ldc             1
        //   307: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   310: invokestatic    java/lang/System.currentTimeMillis:()J
        //   313: lcmp           
        //   314: ldc             2
        //   316: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   319: ifgt            653
        //   322: aload_3        
        //   323: getstatic       instrumented/java/util/ResourceBundle.NONEXISTENT_BUNDLE:Linstrumented/java/util/ResourceBundle;
        //   326: ldc             3
        //   328: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   331: if_acmpeq       625
        //   334: aload_3        
        //   335: dup            
        //   336: astore          8
        //   338: pop            
        //   339: ldc             4
        //   341: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   344: aload           5
        //   346: ldc             2
        //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   351: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$600:(Linstrumented/java/util/ResourceBundle$CacheKey;)J
        //   354: lstore          6
        //   356: ldc             1
        //   358: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   361: aload_3        
        //   362: getfield        instrumented/java/util/ResourceBundle.expired:Z
        //   365: ldc             3
        //   367: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   370: ifne            582
        //   373: lload           6
        //   375: lconst_0       
        //   376: lcmp           
        //   377: ldc             4
        //   379: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   382: iflt            582
        //   385: lload           6
        //   387: ldc             1
        //   389: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   392: ldc             1
        //   394: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   397: invokestatic    java/lang/System.currentTimeMillis:()J
        //   400: lcmp           
        //   401: ldc             2
        //   403: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   406: ifgt            582
        //   409: aload_3        
        //   410: aload_1        
        //   411: aload           5
        //   413: ldc             4
        //   415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   418: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getName:()Ljava/lang/String;
        //   421: aload           5
        //   423: ldc             1
        //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   428: ldc             1
        //   430: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   433: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getLocale:()Linstrumented/java/util/Locale;
        //   436: aload           5
        //   438: ldc             1
        //   440: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   443: ldc             1
        //   445: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   448: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getFormat:()Ljava/lang/String;
        //   451: aload           5
        //   453: ldc             1
        //   455: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   458: ldc             1
        //   460: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   463: invokevirtual   instrumented/java/util/ResourceBundle$CacheKey.getLoader:()Ljava/lang/ClassLoader;
        //   466: aload_3        
        //   467: aload           5
        //   469: ldc             2
        //   471: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   474: ldc             1
        //   476: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   479: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$700:(Linstrumented/java/util/ResourceBundle$CacheKey;)J
        //   482: ldc             1
        //   484: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   487: invokevirtual   instrumented/java/util/ResourceBundle$Control.needsReload:(Ljava/lang/String;Linstrumented/java/util/Locale;Ljava/lang/String;Ljava/lang/ClassLoader;Linstrumented/java/util/ResourceBundle;J)Z
        //   490: putfield        instrumented/java/util/ResourceBundle.expired:Z
        //   493: ldc             1
        //   495: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   498: ldc             1
        //   500: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   503: goto            525
        //   506: astore          9
        //   508: ldc_w           501
        //   511: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   514: aload_0        
        //   515: aload           9
        //   517: ldc             3
        //   519: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   522: invokestatic    instrumented/java/util/ResourceBundle$CacheKey.access$500:(Linstrumented/java/util/ResourceBundle$CacheKey;Ljava/lang/Throwable;)V
        //   525: aload_3        
        //   526: getfield        instrumented/java/util/ResourceBundle.expired:Z
        //   529: ldc             3
        //   531: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   534: ifeq            571
        //   537: aload_3        
        //   538: aconst_null    
        //   539: putfield        instrumented/java/util/ResourceBundle.cacheKey:Linstrumented/java/util/ResourceBundle$CacheKey;
        //   542: ldc             3
        //   544: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   547: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   550: aload_0        
        //   551: aload_2        
        //   552: ldc             4
        //   554: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   557: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.remove:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   562: pop            
        //   563: ldc             2
        //   565: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   568: goto            582
        //   571: aload           5
        //   573: aload_1        
        //   574: ldc             3
        //   576: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   579: invokestatic    instrumented/java/util/ResourceBundle.setExpirationTime:(Linstrumented/java/util/ResourceBundle$CacheKey;Linstrumented/java/util/ResourceBundle$Control;)V
        //   582: aload           8
        //   584: pop            
        //   585: ldc             2
        //   587: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   590: ldc             1
        //   592: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   595: goto            617
        //   598: astore          10
        //   600: aload           8
        //   602: pop            
        //   603: ldc_w           503
        //   606: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   609: aload           10
        //   611: ldc             2
        //   613: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   616: athrow         
        //   617: ldc             1
        //   619: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   622: goto            653
        //   625: getstatic       instrumented/java/util/ResourceBundle.cacheList:Linstrumented/java/util/concurrent/ConcurrentMap;
        //   628: aload_0        
        //   629: aload_2        
        //   630: ldc             4
        //   632: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   635: invokeinterface instrumented/java/util/concurrent/ConcurrentMap.remove:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   640: pop            
        //   641: ldc             1
        //   643: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   646: aconst_null    
        //   647: astore_3       
        //   648: ldc             2
        //   650: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   653: aload_3        
        //   654: ldc             2
        //   656: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   659: areturn        
        //   660: athrow         
        //   661: athrow         
        //    StackMapTable: 00 0F FC 00 27 07 00 09 FC 00 21 07 00 02 FC 00 34 07 00 02 3F 32 FF 01 08 00 08 07 00 0C 07 00 12 07 00 09 07 00 02 07 00 02 07 00 0C 04 07 00 04 00 01 07 01 56 12 2D 0A 4F 07 00 47 FA 00 12 07 F9 00 1B FF 00 06 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 01 1C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  344    661    661    662    Ljava/lang/VirtualMachineError;
        //  409    498    506    525    Ljava/lang/Exception;
        //  344    590    598    617    Any
        //  598    609    598    617    Any
        //  0      660    660    661    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0525:
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
    
    private static ResourceBundle putBundleInCache(final CacheKey cacheKey, ResourceBundle resourceBundle, final Control control) {
        try {
            BytecodeManager.incBytecodes(3);
            setExpirationTime(cacheKey, control);
            BytecodeManager.incBytecodes(2);
            final long n = lcmp(CacheKey.access$600(cacheKey), -1L);
            BytecodeManager.incBytecodes(3);
            Label_0220: {
                if (n != 0) {
                    BytecodeManager.incBytecodes(2);
                    final CacheKey cacheKey2 = (CacheKey)cacheKey.clone();
                    BytecodeManager.incBytecodes(2);
                    final ResourceBundle resourceBundle2 = resourceBundle;
                    final ReferenceQueue<Object> referenceQueue = ResourceBundle.referenceQueue;
                    final CacheKey cacheKey3 = cacheKey2;
                    BytecodeManager.incBytecodes(6);
                    final BundleReference bundleReference = new BundleReference(resourceBundle2, referenceQueue, cacheKey3);
                    BytecodeManager.incBytecodes(1);
                    resourceBundle.cacheKey = cacheKey2;
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentMap<CacheKey, BundleReference> cacheList = ResourceBundle.cacheList;
                    final CacheKey cacheKey4 = cacheKey2;
                    final BundleReference bundleReference2 = bundleReference;
                    BytecodeManager.incBytecodes(4);
                    final BundleReference bundleReference3 = cacheList.putIfAbsent(cacheKey4, bundleReference2);
                    BytecodeManager.incBytecodes(2);
                    final BundleReference bundleReference4 = bundleReference3;
                    BytecodeManager.incBytecodes(2);
                    if (bundleReference4 != null) {
                        final BundleReference bundleReference5 = bundleReference3;
                        BytecodeManager.incBytecodes(2);
                        final ResourceBundle resourceBundle3 = bundleReference5.get();
                        BytecodeManager.incBytecodes(2);
                        final ResourceBundle resourceBundle4 = resourceBundle3;
                        BytecodeManager.incBytecodes(2);
                        if (resourceBundle4 != null) {
                            final boolean expired = resourceBundle3.expired;
                            BytecodeManager.incBytecodes(3);
                            if (!expired) {
                                resourceBundle.cacheKey = null;
                                BytecodeManager.incBytecodes(3);
                                resourceBundle = resourceBundle3;
                                BytecodeManager.incBytecodes(2);
                                final BundleReference bundleReference6 = bundleReference;
                                BytecodeManager.incBytecodes(2);
                                bundleReference6.clear();
                                BytecodeManager.incBytecodes(1);
                                break Label_0220;
                            }
                        }
                        final ConcurrentMap<CacheKey, BundleReference> cacheList2 = ResourceBundle.cacheList;
                        final CacheKey cacheKey5 = cacheKey2;
                        final BundleReference bundleReference7 = bundleReference;
                        BytecodeManager.incBytecodes(4);
                        cacheList2.put(cacheKey5, bundleReference7);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            final ResourceBundle resourceBundle5 = resourceBundle;
            BytecodeManager.incBytecodes(2);
            return resourceBundle5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static void setExpirationTime(final CacheKey cacheKey, final Control control) {
        try {
            BytecodeManager.incBytecodes(3);
            final String name = cacheKey.getName();
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final Locale locale = cacheKey.getLocale();
            BytecodeManager.incBytecodes(1);
            final long timeToLive = control.getTimeToLive(name, locale);
            BytecodeManager.incBytecodes(1);
            final long n = lcmp(timeToLive, 0L);
            BytecodeManager.incBytecodes(4);
            if (n >= 0) {
                BytecodeManager.incBytecodes(1);
                final long currentTimeMillis = System.currentTimeMillis();
                BytecodeManager.incBytecodes(1);
                final long n2 = currentTimeMillis;
                BytecodeManager.incBytecodes(3);
                CacheKey.access$702(cacheKey, n2);
                BytecodeManager.incBytecodes(1);
                final long n3 = currentTimeMillis + timeToLive;
                BytecodeManager.incBytecodes(5);
                CacheKey.access$602(cacheKey, n3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            else {
                final long n4 = lcmp(timeToLive, -2L);
                BytecodeManager.incBytecodes(4);
                if (n4 < 0) {
                    BytecodeManager.incBytecodes(5);
                    final StringBuilder sb = new StringBuilder();
                    final String str = "Invalid Control: TTL=";
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append = sb.append(str);
                    final long lng = timeToLive;
                    BytecodeManager.incBytecodes(2);
                    final StringBuilder append2 = append.append(lng);
                    BytecodeManager.incBytecodes(1);
                    final String string = append2.toString();
                    BytecodeManager.incBytecodes(1);
                    final IllegalArgumentException ex = new IllegalArgumentException(string);
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final long n5 = timeToLive;
                BytecodeManager.incBytecodes(3);
                CacheKey.access$602(cacheKey, n5);
                BytecodeManager.incBytecodes(2);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @CallerSensitive
    public static final void clearCache() {
        try {
            BytecodeManager.incBytecodes(1);
            final Class callerClass = Reflection.getCallerClass();
            BytecodeManager.incBytecodes(1);
            final ClassLoader loader = getLoader(callerClass);
            BytecodeManager.incBytecodes(1);
            clearCache(loader);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public static final void clearCache(final ClassLoader classLoader) {
        try {
            BytecodeManager.incBytecodes(2);
            if (classLoader == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final ConcurrentMap<CacheKey, BundleReference> cacheList = ResourceBundle.cacheList;
            BytecodeManager.incBytecodes(2);
            final Set<CacheKey> keySet = cacheList.keySet();
            BytecodeManager.incBytecodes(1);
            final Set<CacheKey> set = keySet;
            BytecodeManager.incBytecodes(2);
            final Iterator<CacheKey> iterator = set.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<CacheKey> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<CacheKey> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final CacheKey cacheKey = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final CacheKey cacheKey2 = cacheKey;
                BytecodeManager.incBytecodes(2);
                final ClassLoader loader = cacheKey2.getLoader();
                BytecodeManager.incBytecodes(2);
                if (loader == classLoader) {
                    final Set<CacheKey> set2 = keySet;
                    final CacheKey cacheKey3 = cacheKey;
                    BytecodeManager.incBytecodes(3);
                    set2.remove(cacheKey3);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected abstract Object handleGetObject(final String p0);
    
    public abstract Enumeration<String> getKeys();
    
    public boolean containsKey(final String s) {
        try {
            BytecodeManager.incBytecodes(2);
            if (s == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            ResourceBundle parent = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final ResourceBundle resourceBundle = parent;
                BytecodeManager.incBytecodes(2);
                if (resourceBundle == null) {
                    final boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    return b;
                }
                final ResourceBundle resourceBundle2 = parent;
                BytecodeManager.incBytecodes(2);
                final Set<String> handleKeySet = resourceBundle2.handleKeySet();
                BytecodeManager.incBytecodes(2);
                final boolean contains = handleKeySet.contains(s);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final boolean b2 = true;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                parent = parent.parent;
                BytecodeManager.incBytecodes(4);
            }
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public Set<String> keySet() {
        try {
            BytecodeManager.incBytecodes(3);
            final HashSet<String> set = (HashSet<String>)new HashSet<Object>();
            BytecodeManager.incBytecodes(1);
            ResourceBundle parent = this;
            BytecodeManager.incBytecodes(2);
            while (true) {
                final ResourceBundle resourceBundle = parent;
                BytecodeManager.incBytecodes(2);
                if (resourceBundle == null) {
                    break;
                }
                final HashSet<String> set2 = set;
                final ResourceBundle resourceBundle2 = parent;
                BytecodeManager.incBytecodes(3);
                final Set<String> handleKeySet = resourceBundle2.handleKeySet();
                BytecodeManager.incBytecodes(1);
                set2.addAll((Collection<?>)handleKeySet);
                BytecodeManager.incBytecodes(1);
                parent = parent.parent;
                BytecodeManager.incBytecodes(4);
            }
            final Set<Object> set3 = (Set<Object>)set;
            BytecodeManager.incBytecodes(2);
            return (Set<String>)set3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected Set<String> handleKeySet() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        instrumented/java/util/ResourceBundle.keySet:Linstrumented/java/util/Set;
        //     4: ldc             3
        //     6: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //     9: ifnonnull       195
        //    12: aload_0        
        //    13: dup            
        //    14: astore_1       
        //    15: pop            
        //    16: ldc             4
        //    18: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    21: aload_0        
        //    22: getfield        instrumented/java/util/ResourceBundle.keySet:Linstrumented/java/util/Set;
        //    25: ldc             3
        //    27: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    30: ifnonnull       162
        //    33: new             Linstrumented/java/util/HashSet;
        //    36: dup            
        //    37: ldc             3
        //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    42: invokespecial   instrumented/java/util/HashSet.<init>:()V
        //    45: astore_2       
        //    46: ldc             1
        //    48: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    51: aload_0        
        //    52: ldc             2
        //    54: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    57: invokevirtual   instrumented/java/util/ResourceBundle.getKeys:()Linstrumented/java/util/Enumeration;
        //    60: astore_3       
        //    61: ldc             1
        //    63: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    66: aload_3        
        //    67: ldc             2
        //    69: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    72: invokeinterface instrumented/java/util/Enumeration.hasMoreElements:()Z
        //    77: ldc             1
        //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    82: ifeq            152
        //    85: aload_3        
        //    86: ldc             2
        //    88: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //    91: invokeinterface instrumented/java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //    96: checkcast       Ljava/lang/String;
        //    99: astore          4
        //   101: ldc             2
        //   103: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   106: aload_0        
        //   107: aload           4
        //   109: ldc             3
        //   111: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   114: invokevirtual   instrumented/java/util/ResourceBundle.handleGetObject:(Ljava/lang/String;)Ljava/lang/Object;
        //   117: ldc             1
        //   119: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   122: ifnull          144
        //   125: aload_2        
        //   126: aload           4
        //   128: ldc             3
        //   130: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   133: invokeinterface instrumented/java/util/Set.add:(Ljava/lang/Object;)Z
        //   138: pop            
        //   139: ldc             1
        //   141: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   144: ldc             1
        //   146: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   149: goto            66
        //   152: aload_0        
        //   153: aload_2        
        //   154: putfield        instrumented/java/util/ResourceBundle.keySet:Linstrumented/java/util/Set;
        //   157: ldc             3
        //   159: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   162: aload_1        
        //   163: pop            
        //   164: ldc             2
        //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   169: ldc             1
        //   171: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   174: goto            195
        //   177: astore          5
        //   179: aload_1        
        //   180: pop            
        //   181: ldc_w           503
        //   184: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   187: aload           5
        //   189: ldc             2
        //   191: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   194: athrow         
        //   195: aload_0        
        //   196: getfield        instrumented/java/util/ResourceBundle.keySet:Linstrumented/java/util/Set;
        //   199: ldc             3
        //   201: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
        //   204: areturn        
        //   205: athrow         
        //   206: athrow         
        //    Signature:
        //  ()Linstrumented/java/util/Set<Ljava/lang/String;>;
        //    StackMapTable: 00 08 FE 00 42 07 00 04 07 01 BA 07 01 D4 FB 00 4D 07 F9 00 09 4E 07 00 47 FA 00 11 FF 00 09 00 00 00 01 07 00 47 FF 00 00 00 00 00 01 07 01 1C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  21     206    206    207    Ljava/lang/VirtualMachineError;
        //  21     169    177    195    Any
        //  177    187    177    195    Any
        //  0      205    205    206    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
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
    
    static /* synthetic */ ReferenceQueue access$200() {
        try {
            final ReferenceQueue<Object> referenceQueue = ResourceBundle.referenceQueue;
            BytecodeManager.incBytecodes(2);
            return referenceQueue;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static {
        try {
            final Class<ResourceBundle> clazz = ResourceBundle.class;
            BytecodeManager.incBytecodes(2);
            final boolean desiredAssertionStatus = clazz.desiredAssertionStatus();
            BytecodeManager.incBytecodes(1);
            boolean $assertionsDisabled2;
            if (!desiredAssertionStatus) {
                $assertionsDisabled2 = true;
                BytecodeManager.incBytecodes(2);
            }
            else {
                $assertionsDisabled2 = false;
                BytecodeManager.incBytecodes(1);
            }
            $assertionsDisabled = $assertionsDisabled2;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            NONEXISTENT_BUNDLE = new ResourceBundle() {
                {
                    BytecodeManager.incBytecodes(1);
                }
                
                @Override
                public Enumeration<String> getKeys() {
                    try {
                        final Enumeration<String> enumeration = null;
                        BytecodeManager.incBytecodes(2);
                        return enumeration;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                protected Object handleGetObject(final String s) {
                    try {
                        final Object o = null;
                        BytecodeManager.incBytecodes(2);
                        return o;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
                
                @Override
                public String toString() {
                    try {
                        final String s = "NONEXISTENT_BUNDLE";
                        BytecodeManager.incBytecodes(2);
                        return s;
                    }
                    finally {
                        throw loadexception(java.lang.Throwable.class);
                    }
                }
            };
            BytecodeManager.incBytecodes(1);
            final int n = 32;
            BytecodeManager.incBytecodes(4);
            cacheList = new ConcurrentHashMap<CacheKey, BundleReference>(n);
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(3);
            referenceQueue = new ReferenceQueue<Object>();
            BytecodeManager.incBytecodes(1);
            List<ResourceBundleControlProvider> providers2 = null;
            BytecodeManager.incBytecodes(2);
            final Class<ResourceBundleControlProvider> clazz2 = ResourceBundleControlProvider.class;
            BytecodeManager.incBytecodes(1);
            BytecodeManager.incBytecodes(1);
            final ServiceLoader<ResourceBundleControlProvider> loadInstalled = ServiceLoader.loadInstalled(clazz2);
            BytecodeManager.incBytecodes(1);
            final ServiceLoader<ResourceBundleControlProvider> serviceLoader = loadInstalled;
            BytecodeManager.incBytecodes(2);
            final Iterator<ResourceBundleControlProvider> iterator = serviceLoader.iterator();
            BytecodeManager.incBytecodes(1);
            while (true) {
                final Iterator<ResourceBundleControlProvider> iterator2 = iterator;
                BytecodeManager.incBytecodes(2);
                final boolean hasNext = iterator2.hasNext();
                BytecodeManager.incBytecodes(1);
                if (!hasNext) {
                    break;
                }
                final Iterator<ResourceBundleControlProvider> iterator3 = iterator;
                BytecodeManager.incBytecodes(2);
                final ResourceBundleControlProvider resourceBundleControlProvider = iterator3.next();
                BytecodeManager.incBytecodes(2);
                final List<ResourceBundleControlProvider> list = providers2;
                BytecodeManager.incBytecodes(2);
                if (list == null) {
                    BytecodeManager.incBytecodes(3);
                    providers2 = new ArrayList<ResourceBundleControlProvider>();
                    BytecodeManager.incBytecodes(1);
                }
                final List<ResourceBundleControlProvider> list2 = providers2;
                final ResourceBundleControlProvider resourceBundleControlProvider2 = resourceBundleControlProvider;
                BytecodeManager.incBytecodes(3);
                list2.add(resourceBundleControlProvider2);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(1);
            }
            providers = providers2;
            BytecodeManager.incBytecodes(2);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private static class RBClassLoader extends ClassLoader
    {
        private static final RBClassLoader INSTANCE;
        private static final ClassLoader loader;
        
        private RBClassLoader() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Class<?> loadClass(final String s) throws ClassNotFoundException {
            try {
                final ClassLoader loader = RBClassLoader.loader;
                BytecodeManager.incBytecodes(2);
                if (loader != null) {
                    final ClassLoader loader2 = RBClassLoader.loader;
                    BytecodeManager.incBytecodes(3);
                    final Class<?> loadClass = loader2.loadClass(s);
                    BytecodeManager.incBytecodes(1);
                    return loadClass;
                }
                BytecodeManager.incBytecodes(2);
                final Class<?> forName = Class.forName(s);
                BytecodeManager.incBytecodes(1);
                return forName;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public URL getResource(final String s) {
            try {
                final ClassLoader loader = RBClassLoader.loader;
                BytecodeManager.incBytecodes(2);
                if (loader != null) {
                    final ClassLoader loader2 = RBClassLoader.loader;
                    BytecodeManager.incBytecodes(3);
                    final URL resource = loader2.getResource(s);
                    BytecodeManager.incBytecodes(1);
                    return resource;
                }
                BytecodeManager.incBytecodes(2);
                final URL systemResource = ClassLoader.getSystemResource(s);
                BytecodeManager.incBytecodes(1);
                return systemResource;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public InputStream getResourceAsStream(final String s) {
            try {
                final ClassLoader loader = RBClassLoader.loader;
                BytecodeManager.incBytecodes(2);
                if (loader != null) {
                    final ClassLoader loader2 = RBClassLoader.loader;
                    BytecodeManager.incBytecodes(3);
                    final InputStream resourceAsStream = loader2.getResourceAsStream(s);
                    BytecodeManager.incBytecodes(1);
                    return resourceAsStream;
                }
                BytecodeManager.incBytecodes(2);
                final InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(s);
                BytecodeManager.incBytecodes(1);
                return systemResourceAsStream;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ RBClassLoader access$000() {
            try {
                final RBClassLoader instance = RBClassLoader.INSTANCE;
                BytecodeManager.incBytecodes(2);
                return instance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                BytecodeManager.incBytecodes(3);
                final PrivilegedAction<RBClassLoader> action = new PrivilegedAction<RBClassLoader>() {
                    {
                        BytecodeManager.incBytecodes(1);
                    }
                    
                    @Override
                    public RBClassLoader run() {
                        try {
                            final ResourceBundle resourceBundle = null;
                            BytecodeManager.incBytecodes(4);
                            final RBClassLoader rbClassLoader = new RBClassLoader();
                            BytecodeManager.incBytecodes(1);
                            return rbClassLoader;
                        }
                        finally {
                            throw loadexception(java.lang.Throwable.class);
                        }
                    }
                };
                BytecodeManager.incBytecodes(1);
                INSTANCE = AccessController.doPrivileged((PrivilegedAction<RBClassLoader>)action);
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
                loader = ClassLoader.getSystemClassLoader();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class CacheKey implements Cloneable
    {
        private String name;
        private Locale locale;
        private LoaderReference loaderRef;
        private String format;
        private volatile long loadTime;
        private volatile long expirationTime;
        private Throwable cause;
        private int hashCodeCache;
        
        CacheKey(final String name, final Locale locale, final ClassLoader classLoader) {
            try {
                BytecodeManager.incBytecodes(2);
                this.name = name;
                BytecodeManager.incBytecodes(3);
                this.locale = locale;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(2);
                if (classLoader == null) {
                    this.loaderRef = null;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    BytecodeManager.incBytecodes(5);
                    final ReferenceQueue access$200 = ResourceBundle.access$200();
                    BytecodeManager.incBytecodes(2);
                    this.loaderRef = new LoaderReference(classLoader, access$200, this);
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(2);
                this.calculateHashCode();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        String getName() {
            try {
                final String name = this.name;
                BytecodeManager.incBytecodes(3);
                return name;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CacheKey setName(final String s) {
            try {
                final String name = this.name;
                BytecodeManager.incBytecodes(4);
                final boolean equals = name.equals(s);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    this.name = s;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.calculateHashCode();
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        Locale getLocale() {
            try {
                final Locale locale = this.locale;
                BytecodeManager.incBytecodes(3);
                return locale;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        CacheKey setLocale(final Locale locale) {
            try {
                final Locale locale2 = this.locale;
                BytecodeManager.incBytecodes(4);
                final boolean equals = locale2.equals(locale);
                BytecodeManager.incBytecodes(1);
                if (!equals) {
                    this.locale = locale;
                    BytecodeManager.incBytecodes(3);
                    BytecodeManager.incBytecodes(2);
                    this.calculateHashCode();
                }
                BytecodeManager.incBytecodes(2);
                return this;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        ClassLoader getLoader() {
            try {
                final LoaderReference loaderRef = this.loaderRef;
                BytecodeManager.incBytecodes(3);
                ClassLoader classLoader;
                if (loaderRef != null) {
                    final LoaderReference loaderRef2 = this.loaderRef;
                    BytecodeManager.incBytecodes(3);
                    classLoader = loaderRef2.get();
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    classLoader = null;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return classLoader;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public boolean equals(final Object p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: aload_1        
            //     2: ldc             3
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: if_acmpne       17
            //    10: iconst_1       
            //    11: ldc             2
            //    13: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    16: ireturn        
            //    17: aload_1        
            //    18: checkcast       Linstrumented/java/util/ResourceBundle$CacheKey;
            //    21: astore_2       
            //    22: ldc             3
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: aload_0        
            //    28: getfield        instrumented/java/util/ResourceBundle$CacheKey.hashCodeCache:I
            //    31: aload_2        
            //    32: getfield        instrumented/java/util/ResourceBundle$CacheKey.hashCodeCache:I
            //    35: ldc             5
            //    37: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    40: if_icmpeq       55
            //    43: iconst_0       
            //    44: ldc             1
            //    46: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    49: ldc             1
            //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    54: ireturn        
            //    55: aload_0        
            //    56: getfield        instrumented/java/util/ResourceBundle$CacheKey.name:Ljava/lang/String;
            //    59: aload_2        
            //    60: getfield        instrumented/java/util/ResourceBundle$CacheKey.name:Ljava/lang/String;
            //    63: ldc             5
            //    65: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    68: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    71: ldc             1
            //    73: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    76: ifne            91
            //    79: iconst_0       
            //    80: ldc             1
            //    82: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    85: ldc             1
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: ireturn        
            //    91: aload_0        
            //    92: getfield        instrumented/java/util/ResourceBundle$CacheKey.locale:Linstrumented/java/util/Locale;
            //    95: aload_2        
            //    96: getfield        instrumented/java/util/ResourceBundle$CacheKey.locale:Linstrumented/java/util/Locale;
            //    99: ldc             5
            //   101: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   104: invokevirtual   instrumented/java/util/Locale.equals:(Ljava/lang/Object;)Z
            //   107: ldc             1
            //   109: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   112: ifne            127
            //   115: iconst_0       
            //   116: ldc             1
            //   118: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   121: ldc             1
            //   123: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   126: ireturn        
            //   127: aload_0        
            //   128: getfield        instrumented/java/util/ResourceBundle$CacheKey.loaderRef:Linstrumented/java/util/ResourceBundle$LoaderReference;
            //   131: ldc             3
            //   133: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   136: ifnonnull       172
            //   139: aload_2        
            //   140: getfield        instrumented/java/util/ResourceBundle$CacheKey.loaderRef:Linstrumented/java/util/ResourceBundle$LoaderReference;
            //   143: ldc             3
            //   145: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   148: ifnonnull       160
            //   151: iconst_1       
            //   152: ldc             2
            //   154: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   157: goto            166
            //   160: iconst_0       
            //   161: ldc             1
            //   163: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   166: ldc             1
            //   168: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   171: ireturn        
            //   172: aload_0        
            //   173: getfield        instrumented/java/util/ResourceBundle$CacheKey.loaderRef:Linstrumented/java/util/ResourceBundle$LoaderReference;
            //   176: ldc             3
            //   178: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   181: invokevirtual   instrumented/java/util/ResourceBundle$LoaderReference.get:()Ljava/lang/Object;
            //   184: checkcast       Ljava/lang/ClassLoader;
            //   187: astore_3       
            //   188: ldc             2
            //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   193: aload_2        
            //   194: getfield        instrumented/java/util/ResourceBundle$CacheKey.loaderRef:Linstrumented/java/util/ResourceBundle$LoaderReference;
            //   197: ldc             3
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: ifnull          249
            //   205: aload_3        
            //   206: ldc             2
            //   208: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   211: ifnull          249
            //   214: aload_3        
            //   215: aload_2        
            //   216: getfield        instrumented/java/util/ResourceBundle$CacheKey.loaderRef:Linstrumented/java/util/ResourceBundle$LoaderReference;
            //   219: ldc             3
            //   221: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   224: ldc             1
            //   226: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   229: invokevirtual   instrumented/java/util/ResourceBundle$LoaderReference.get:()Ljava/lang/Object;
            //   232: ldc             1
            //   234: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   237: if_acmpne       249
            //   240: iconst_1       
            //   241: ldc             2
            //   243: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   246: goto            255
            //   249: iconst_0       
            //   250: ldc             1
            //   252: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   255: ldc             1
            //   257: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   260: ireturn        
            //   261: astore_2       
            //   262: ldc             501
            //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   267: iconst_0       
            //   268: ldc             2
            //   270: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   273: ireturn        
            //   274: athrow         
            //   275: athrow         
            //    StackMapTable: 00 0C 11 FC 00 25 07 00 02 23 23 20 45 01 05 FC 00 4C 07 00 35 45 01 FF 00 05 00 02 07 00 02 07 00 04 00 01 07 00 60 FF 00 0C 00 00 00 01 07 00 43 FF 00 00 00 00 00 01 07 00 58
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  17     275    275    276    Ljava/lang/VirtualMachineError;
            //  17     49     261    274    Ljava/lang/NullPointerException;
            //  17     49     261    274    Ljava/lang/ClassCastException;
            //  55     85     261    274    Ljava/lang/NullPointerException;
            //  55     85     261    274    Ljava/lang/ClassCastException;
            //  91     121    261    274    Ljava/lang/NullPointerException;
            //  91     121    261    274    Ljava/lang/ClassCastException;
            //  127    166    261    274    Ljava/lang/NullPointerException;
            //  127    166    261    274    Ljava/lang/ClassCastException;
            //  172    255    261    274    Ljava/lang/NullPointerException;
            //  172    255    261    274    Ljava/lang/ClassCastException;
            //  0      274    274    275    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0017:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        @Override
        public int hashCode() {
            try {
                final int hashCodeCache = this.hashCodeCache;
                BytecodeManager.incBytecodes(3);
                return hashCodeCache;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void calculateHashCode() {
            try {
                final String name = this.name;
                BytecodeManager.incBytecodes(4);
                this.hashCodeCache = name.hashCode() << 3;
                BytecodeManager.incBytecodes(3);
                final int hashCodeCache = this.hashCodeCache;
                final Locale locale = this.locale;
                BytecodeManager.incBytecodes(6);
                this.hashCodeCache = (hashCodeCache ^ locale.hashCode());
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(2);
                final ClassLoader loader = this.getLoader();
                BytecodeManager.incBytecodes(1);
                final ClassLoader classLoader = loader;
                BytecodeManager.incBytecodes(2);
                if (classLoader != null) {
                    final int hashCodeCache2 = this.hashCodeCache;
                    final ClassLoader classLoader2 = loader;
                    BytecodeManager.incBytecodes(5);
                    this.hashCodeCache = (hashCodeCache2 ^ classLoader2.hashCode());
                    BytecodeManager.incBytecodes(2);
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Object clone() {
            try {
                try {
                    BytecodeManager.incBytecodes(2);
                    final CacheKey cacheKey = (CacheKey)super.clone();
                    BytecodeManager.incBytecodes(2);
                    final LoaderReference loaderRef = this.loaderRef;
                    BytecodeManager.incBytecodes(3);
                    if (loaderRef != null) {
                        final CacheKey cacheKey2 = cacheKey;
                        final LoaderReference loaderRef2 = this.loaderRef;
                        BytecodeManager.incBytecodes(6);
                        final ClassLoader classLoader = loaderRef2.get();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final ReferenceQueue access$200 = ResourceBundle.access$200();
                        final CacheKey cacheKey3 = cacheKey;
                        BytecodeManager.incBytecodes(2);
                        cacheKey2.loaderRef = new LoaderReference(classLoader, access$200, cacheKey3);
                        BytecodeManager.incBytecodes(1);
                    }
                    cacheKey.cause = null;
                    BytecodeManager.incBytecodes(3);
                    final CacheKey cacheKey4 = cacheKey;
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(1);
                    return cacheKey4;
                }
                catch (CloneNotSupportedException ex) {
                    BytecodeManager.incBytecodes(501);
                    final CloneNotSupportedException cause = ex;
                    BytecodeManager.incBytecodes(4);
                    final InternalError internalError = new InternalError(cause);
                    BytecodeManager.incBytecodes(1);
                    throw internalError;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            catch (VirtualMachineError virtualMachineError) {
                throw virtualMachineError;
            }
        }
        
        String getFormat() {
            try {
                final String format = this.format;
                BytecodeManager.incBytecodes(3);
                return format;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        void setFormat(final String format) {
            try {
                this.format = format;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private void setCause(final Throwable t) {
            try {
                final Throwable cause = this.cause;
                BytecodeManager.incBytecodes(3);
                if (cause == null) {
                    this.cause = t;
                    BytecodeManager.incBytecodes(4);
                }
                else {
                    final boolean b = this.cause instanceof ClassNotFoundException;
                    BytecodeManager.incBytecodes(4);
                    if (b) {
                        this.cause = t;
                        BytecodeManager.incBytecodes(3);
                    }
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private Throwable getCause() {
            try {
                final Throwable cause = this.cause;
                BytecodeManager.incBytecodes(3);
                return cause;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public String toString() {
            try {
                final Locale locale = this.locale;
                BytecodeManager.incBytecodes(3);
                String s = locale.toString();
                BytecodeManager.incBytecodes(1);
                final String s2 = s;
                BytecodeManager.incBytecodes(2);
                final int length = s2.length();
                BytecodeManager.incBytecodes(1);
                if (length == 0) {
                    final Locale locale2 = this.locale;
                    BytecodeManager.incBytecodes(3);
                    final String variant = locale2.getVariant();
                    BytecodeManager.incBytecodes(1);
                    final int length2 = variant.length();
                    BytecodeManager.incBytecodes(1);
                    if (length2 != 0) {
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder sb = new StringBuilder();
                        final String str = "__";
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append = sb.append(str);
                        final Locale locale3 = this.locale;
                        BytecodeManager.incBytecodes(3);
                        final String variant2 = locale3.getVariant();
                        BytecodeManager.incBytecodes(1);
                        final StringBuilder append2 = append.append(variant2);
                        BytecodeManager.incBytecodes(1);
                        s = append2.toString();
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        s = "\"\"";
                        BytecodeManager.incBytecodes(2);
                    }
                }
                BytecodeManager.incBytecodes(3);
                final StringBuilder sb2 = new StringBuilder();
                final String str2 = "CacheKey[";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append3 = sb2.append(str2);
                final String name = this.name;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append4 = append3.append(name);
                final String str3 = ", lc=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append5 = append4.append(str3);
                final String str4 = s;
                BytecodeManager.incBytecodes(2);
                final StringBuilder append6 = append5.append(str4);
                final String str5 = ", ldr=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append7 = append6.append(str5);
                BytecodeManager.incBytecodes(2);
                final ClassLoader loader = this.getLoader();
                BytecodeManager.incBytecodes(1);
                final StringBuilder append8 = append7.append(loader);
                final String str6 = "(format=";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append9 = append8.append(str6);
                final String format = this.format;
                BytecodeManager.incBytecodes(3);
                final StringBuilder append10 = append9.append(format);
                final String str7 = ")]";
                BytecodeManager.incBytecodes(2);
                final StringBuilder append11 = append10.append(str7);
                BytecodeManager.incBytecodes(1);
                final String string = append11.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Throwable access$400(final CacheKey cacheKey) {
            try {
                BytecodeManager.incBytecodes(2);
                final Throwable cause = cacheKey.getCause();
                BytecodeManager.incBytecodes(1);
                return cause;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ long access$600(final CacheKey cacheKey) {
            try {
                final long expirationTime = cacheKey.expirationTime;
                BytecodeManager.incBytecodes(3);
                return expirationTime;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ long access$702(final CacheKey cacheKey, final long loadTime) {
            try {
                cacheKey.loadTime = loadTime;
                BytecodeManager.incBytecodes(5);
                return loadTime;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ long access$602(final CacheKey cacheKey, final long expirationTime) {
            try {
                cacheKey.expirationTime = expirationTime;
                BytecodeManager.incBytecodes(5);
                return expirationTime;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class LoaderReference extends WeakReference<ClassLoader> implements CacheKeyReference
    {
        private CacheKey cacheKey;
        
        LoaderReference(final ClassLoader referent, final ReferenceQueue<Object> q, final CacheKey cacheKey) {
            try {
                BytecodeManager.incBytecodes(4);
                super(referent, q);
                this.cacheKey = cacheKey;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public CacheKey getCacheKey() {
            try {
                final CacheKey cacheKey = this.cacheKey;
                BytecodeManager.incBytecodes(3);
                return cacheKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static class BundleReference extends SoftReference<ResourceBundle> implements CacheKeyReference
    {
        private CacheKey cacheKey;
        
        BundleReference(final ResourceBundle referent, final ReferenceQueue<Object> q, final CacheKey cacheKey) {
            try {
                BytecodeManager.incBytecodes(4);
                super(referent, q);
                this.cacheKey = cacheKey;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public CacheKey getCacheKey() {
            try {
                final CacheKey cacheKey = this.cacheKey;
                BytecodeManager.incBytecodes(3);
                return cacheKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    public static class Control
    {
        public static final List<String> FORMAT_DEFAULT;
        public static final List<String> FORMAT_CLASS;
        public static final List<String> FORMAT_PROPERTIES;
        public static final long TTL_DONT_CACHE = -1L;
        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
        private static final Control INSTANCE;
        private static final CandidateListCache CANDIDATES_CACHE;
        
        protected Control() {
            try {
                BytecodeManager.incBytecodes(2);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static final Control getControl(final List<String> list) {
            try {
                final List<String> format_PROPERTIES = Control.FORMAT_PROPERTIES;
                BytecodeManager.incBytecodes(3);
                final boolean equals = list.equals(format_PROPERTIES);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    BytecodeManager.incBytecodes(1);
                    final Control access$800 = SingleFormatControl.access$800();
                    BytecodeManager.incBytecodes(1);
                    return access$800;
                }
                final List<String> format_CLASS = Control.FORMAT_CLASS;
                BytecodeManager.incBytecodes(3);
                final boolean equals2 = list.equals(format_CLASS);
                BytecodeManager.incBytecodes(1);
                if (equals2) {
                    BytecodeManager.incBytecodes(1);
                    final Control access$801 = SingleFormatControl.access$900();
                    BytecodeManager.incBytecodes(1);
                    return access$801;
                }
                final List<String> format_DEFAULT = Control.FORMAT_DEFAULT;
                BytecodeManager.incBytecodes(3);
                final boolean equals3 = list.equals(format_DEFAULT);
                BytecodeManager.incBytecodes(1);
                if (equals3) {
                    final Control instance = Control.INSTANCE;
                    BytecodeManager.incBytecodes(2);
                    return instance;
                }
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public static final Control getNoFallbackControl(final List<String> list) {
            try {
                final List<String> format_DEFAULT = Control.FORMAT_DEFAULT;
                BytecodeManager.incBytecodes(3);
                final boolean equals = list.equals(format_DEFAULT);
                BytecodeManager.incBytecodes(1);
                if (equals) {
                    BytecodeManager.incBytecodes(1);
                    final Control access$1000 = NoFallbackControl.access$1000();
                    BytecodeManager.incBytecodes(1);
                    return access$1000;
                }
                final List<String> format_PROPERTIES = Control.FORMAT_PROPERTIES;
                BytecodeManager.incBytecodes(3);
                final boolean equals2 = list.equals(format_PROPERTIES);
                BytecodeManager.incBytecodes(1);
                if (equals2) {
                    BytecodeManager.incBytecodes(1);
                    final Control access$1001 = NoFallbackControl.access$1100();
                    BytecodeManager.incBytecodes(1);
                    return access$1001;
                }
                final List<String> format_CLASS = Control.FORMAT_CLASS;
                BytecodeManager.incBytecodes(3);
                final boolean equals3 = list.equals(format_CLASS);
                BytecodeManager.incBytecodes(1);
                if (equals3) {
                    BytecodeManager.incBytecodes(1);
                    final Control access$1002 = NoFallbackControl.access$1200();
                    BytecodeManager.incBytecodes(1);
                    return access$1002;
                }
                BytecodeManager.incBytecodes(3);
                final IllegalArgumentException ex = new IllegalArgumentException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public List<String> getFormats(final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final List<String> format_DEFAULT = Control.FORMAT_DEFAULT;
                BytecodeManager.incBytecodes(2);
                return format_DEFAULT;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public List<Locale> getCandidateLocales(final String s, final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final CandidateListCache candidates_CACHE = Control.CANDIDATES_CACHE;
                BytecodeManager.incBytecodes(5);
                final BaseLocale baseLocale = locale.getBaseLocale();
                BytecodeManager.incBytecodes(1);
                final Collection<? extends Locale> collection = ((LocaleObjectCache<BaseLocale, Collection<? extends Locale>>)candidates_CACHE).get(baseLocale);
                BytecodeManager.incBytecodes(2);
                final ArrayList list = new ArrayList<Locale>(collection);
                BytecodeManager.incBytecodes(1);
                return (List<Locale>)list;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public Locale getFallbackLocale(final String s, final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                BytecodeManager.incBytecodes(1);
                final Locale default1 = Locale.getDefault();
                BytecodeManager.incBytecodes(1);
                final Locale locale2 = default1;
                BytecodeManager.incBytecodes(3);
                final boolean equals = locale.equals(locale2);
                BytecodeManager.incBytecodes(1);
                Locale locale3;
                if (equals) {
                    locale3 = null;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    locale3 = default1;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return locale3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public ResourceBundle newBundle(final String p0, final Locale p1, final String p2, final ClassLoader p3, final boolean p4) throws IllegalAccessException, InstantiationException, IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: aload_1        
            //     2: aload_2        
            //     3: ldc             4
            //     5: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     8: invokevirtual   instrumented/java/util/ResourceBundle$Control.toBundleName:(Ljava/lang/String;Linstrumented/java/util/Locale;)Ljava/lang/String;
            //    11: astore          6
            //    13: ldc             1
            //    15: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    18: aconst_null    
            //    19: astore          7
            //    21: ldc             2
            //    23: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    26: aload_3        
            //    27: ldc             "java.class"
            //    29: ldc             3
            //    31: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    34: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    37: ldc             1
            //    39: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    42: ifeq            201
            //    45: aload           4
            //    47: aload           6
            //    49: ldc             2
            //    51: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    54: ldc             1
            //    56: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    59: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
            //    62: astore          8
            //    64: ldc             1
            //    66: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    69: ldc             Linstrumented/java/util/ResourceBundle;.class
            //    71: aload           8
            //    73: ldc             3
            //    75: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    78: invokevirtual   java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
            //    81: ldc             1
            //    83: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    86: ifeq            112
            //    89: aload           8
            //    91: ldc             2
            //    93: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    96: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
            //    99: checkcast       Linstrumented/java/util/ResourceBundle;
            //   102: astore          7
            //   104: ldc             3
            //   106: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   109: goto            178
            //   112: new             Ljava/lang/ClassCastException;
            //   115: dup            
            //   116: new             Ljava/lang/StringBuilder;
            //   119: dup            
            //   120: ldc             5
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: invokespecial   java/lang/StringBuilder.<init>:()V
            //   128: aload           8
            //   130: ldc             2
            //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   135: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
            //   138: ldc             1
            //   140: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   143: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   146: ldc             " cannot be cast to ResourceBundle"
            //   148: ldc             2
            //   150: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   153: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   156: ldc             1
            //   158: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   161: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   164: ldc             1
            //   166: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   169: invokespecial   java/lang/ClassCastException.<init>:(Ljava/lang/String;)V
            //   172: ldc             1
            //   174: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   177: athrow         
            //   178: ldc             1
            //   180: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   183: goto            494
            //   186: astore          8
            //   188: ldc             501
            //   190: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   193: ldc             1
            //   195: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   198: goto            494
            //   201: aload_3        
            //   202: ldc             "java.properties"
            //   204: ldc             3
            //   206: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   209: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //   212: ldc             1
            //   214: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   217: ifeq            437
            //   220: aload_0        
            //   221: aload           6
            //   223: ldc             "properties"
            //   225: ldc             4
            //   227: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   230: invokespecial   instrumented/java/util/ResourceBundle$Control.toResourceName0:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   233: astore          8
            //   235: ldc             1
            //   237: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   240: aload           8
            //   242: ldc             2
            //   244: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   247: ifnonnull       258
            //   250: aload           7
            //   252: ldc             2
            //   254: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   257: areturn        
            //   258: aload           4
            //   260: astore          9
            //   262: ldc             2
            //   264: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   267: iload           5
            //   269: istore          10
            //   271: ldc             2
            //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   276: aconst_null    
            //   277: astore          11
            //   279: ldc             2
            //   281: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   284: new             Linstrumented/java/util/ResourceBundle$Control$1;
            //   287: dup            
            //   288: aload_0        
            //   289: iload           10
            //   291: aload           9
            //   293: aload           8
            //   295: ldc             7
            //   297: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   300: invokespecial   instrumented/java/util/ResourceBundle$Control$1.<init>:(Linstrumented/java/util/ResourceBundle$Control;ZLjava/lang/ClassLoader;Ljava/lang/String;)V
            //   303: ldc             1
            //   305: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   308: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
            //   311: checkcast       Ljava/io/InputStream;
            //   314: astore          11
            //   316: ldc             2
            //   318: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   321: ldc             1
            //   323: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   326: goto            355
            //   329: astore          12
            //   331: ldc             501
            //   333: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   336: aload           12
            //   338: ldc             2
            //   340: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   343: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
            //   346: checkcast       Ljava/io/IOException;
            //   349: ldc             2
            //   351: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   354: athrow         
            //   355: aload           11
            //   357: ldc             2
            //   359: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   362: ifnull          429
            //   365: new             Linstrumented/java/util/PropertyResourceBundle;
            //   368: dup            
            //   369: aload           11
            //   371: ldc             4
            //   373: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   376: invokespecial   instrumented/java/util/PropertyResourceBundle.<init>:(Ljava/io/InputStream;)V
            //   379: astore          7
            //   381: ldc             1
            //   383: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   386: aload           11
            //   388: ldc             2
            //   390: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   393: invokevirtual   java/io/InputStream.close:()V
            //   396: ldc             1
            //   398: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   401: goto            429
            //   404: astore          13
            //   406: ldc             501
            //   408: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   411: aload           11
            //   413: ldc             2
            //   415: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   418: invokevirtual   java/io/InputStream.close:()V
            //   421: aload           13
            //   423: ldc             2
            //   425: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   428: athrow         
            //   429: ldc             1
            //   431: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   434: goto            494
            //   437: new             Ljava/lang/IllegalArgumentException;
            //   440: dup            
            //   441: new             Ljava/lang/StringBuilder;
            //   444: dup            
            //   445: ldc             5
            //   447: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   450: invokespecial   java/lang/StringBuilder.<init>:()V
            //   453: ldc             "unknown format: "
            //   455: ldc             2
            //   457: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   460: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   463: aload_3        
            //   464: ldc             2
            //   466: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   469: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   472: ldc             1
            //   474: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   477: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   480: ldc             1
            //   482: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   485: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
            //   488: ldc             1
            //   490: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   493: athrow         
            //   494: aload           7
            //   496: ldc             2
            //   498: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   501: areturn        
            //   502: athrow         
            //   503: athrow         
            //    Exceptions:
            //  throws java.lang.IllegalAccessException
            //  throws java.lang.InstantiationException
            //  throws java.io.IOException
            //    StackMapTable: 00 0D FE 00 70 07 00 91 07 00 07 07 00 9A FA 00 41 47 07 00 86 0E FC 00 38 07 00 91 FF 00 46 00 0C 07 00 02 07 00 91 07 00 66 07 00 91 07 00 94 01 07 00 91 07 00 07 07 00 91 07 00 94 01 07 00 CC 00 01 07 00 88 19 70 07 00 33 FF 00 18 00 08 07 00 02 07 00 91 07 00 66 07 00 91 07 00 94 01 07 00 91 07 00 07 00 00 07 38 FF 00 07 00 00 00 01 07 00 33 FF 00 00 00 00 00 01 07 00 84
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                     
            //  -----  -----  -----  -----  -----------------------------------------
            //  45     503    503    504    Ljava/lang/VirtualMachineError;
            //  45     178    186    201    Ljava/lang/ClassNotFoundException;
            //  284    321    329    355    Ljava/security/PrivilegedActionException;
            //  365    386    404    429    Any
            //  404    411    404    429    Any
            //  0      502    502    503    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public long getTimeToLive(final String s, final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    BytecodeManager.incBytecodes(2);
                    if (locale != null) {
                        final long n = -2L;
                        BytecodeManager.incBytecodes(2);
                        return n;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public boolean needsReload(final String p0, final Locale p1, final String p2, final ClassLoader p3, final ResourceBundle p4, final long p5) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     2: ldc             2
            //     4: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //     7: ifnonnull       28
            //    10: new             Ljava/lang/NullPointerException;
            //    13: dup            
            //    14: ldc             3
            //    16: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    19: invokespecial   java/lang/NullPointerException.<init>:()V
            //    22: ldc             1
            //    24: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    27: athrow         
            //    28: aload_3        
            //    29: ldc             "java.class"
            //    31: ldc             3
            //    33: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    36: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    39: ldc             1
            //    41: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    44: ifne            66
            //    47: aload_3        
            //    48: ldc             "java.properties"
            //    50: ldc             3
            //    52: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    55: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    58: ldc             1
            //    60: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    63: ifeq            82
            //    66: aload_3        
            //    67: iconst_5       
            //    68: ldc             3
            //    70: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    73: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
            //    76: astore_3       
            //    77: ldc             1
            //    79: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    82: iconst_0       
            //    83: istore          8
            //    85: ldc             2
            //    87: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    90: aload_0        
            //    91: aload_0        
            //    92: aload_1        
            //    93: aload_2        
            //    94: ldc             5
            //    96: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //    99: invokevirtual   instrumented/java/util/ResourceBundle$Control.toBundleName:(Ljava/lang/String;Linstrumented/java/util/Locale;)Ljava/lang/String;
            //   102: aload_3        
            //   103: ldc             2
            //   105: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   108: invokespecial   instrumented/java/util/ResourceBundle$Control.toResourceName0:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   111: astore          9
            //   113: ldc             1
            //   115: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   118: aload           9
            //   120: ldc             2
            //   122: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   125: ifnonnull       141
            //   128: iload           8
            //   130: ldc             1
            //   132: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   135: ldc             1
            //   137: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   140: ireturn        
            //   141: aload           4
            //   143: aload           9
            //   145: ldc             3
            //   147: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   150: invokevirtual   java/lang/ClassLoader.getResource:(Ljava/lang/String;)Ljava/net/URL;
            //   153: astore          10
            //   155: ldc             1
            //   157: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   160: aload           10
            //   162: ldc             2
            //   164: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   167: ifnull          358
            //   170: lconst_0       
            //   171: lstore          11
            //   173: ldc             2
            //   175: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   178: aload           10
            //   180: ldc             2
            //   182: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   185: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
            //   188: astore          13
            //   190: ldc             1
            //   192: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   195: aload           13
            //   197: ldc             2
            //   199: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   202: ifnull          323
            //   205: aload           13
            //   207: iconst_0       
            //   208: ldc             3
            //   210: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   213: invokevirtual   java/net/URLConnection.setUseCaches:(Z)V
            //   216: aload           13
            //   218: instanceof      Ljava/net/JarURLConnection;
            //   221: ldc             3
            //   223: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   226: ifeq            306
            //   229: aload           13
            //   231: checkcast       Ljava/net/JarURLConnection;
            //   234: ldc             3
            //   236: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   239: invokevirtual   java/net/JarURLConnection.getJarEntry:()Ljava/util/jar/JarEntry;
            //   242: astore          14
            //   244: ldc             1
            //   246: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   249: aload           14
            //   251: ldc             2
            //   253: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   256: ifnull          298
            //   259: aload           14
            //   261: ldc             2
            //   263: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   266: invokevirtual   java/util/jar/JarEntry.getTime:()J
            //   269: lstore          11
            //   271: ldc             1
            //   273: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   276: lload           11
            //   278: ldc2_w          -1
            //   281: lcmp           
            //   282: ldc             4
            //   284: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   287: ifne            298
            //   290: lconst_0       
            //   291: lstore          11
            //   293: ldc             2
            //   295: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   298: ldc             1
            //   300: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   303: goto            323
            //   306: aload           13
            //   308: ldc             2
            //   310: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   313: invokevirtual   java/net/URLConnection.getLastModified:()J
            //   316: lstore          11
            //   318: ldc             1
            //   320: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   323: lload           11
            //   325: lload           6
            //   327: lcmp           
            //   328: ldc             4
            //   330: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   333: iflt            345
            //   336: iconst_1       
            //   337: ldc             2
            //   339: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   342: goto            351
            //   345: iconst_0       
            //   346: ldc             1
            //   348: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   351: istore          8
            //   353: ldc             1
            //   355: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   358: ldc             1
            //   360: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   363: goto            388
            //   366: astore          9
            //   368: ldc             501
            //   370: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   373: aload           9
            //   375: ldc             2
            //   377: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   380: athrow         
            //   381: astore          9
            //   383: ldc             501
            //   385: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   388: iload           8
            //   390: ldc             2
            //   392: invokestatic    aic2021/engine/BytecodeManager.incBytecodes:(I)V
            //   395: ireturn        
            //   396: athrow         
            //   397: athrow         
            //    StackMapTable: 00 0F 1C 25 0F FD 00 3A 01 07 00 91 FE 00 9C 07 00 EB 04 07 00 F1 07 10 15 45 01 FF 00 06 00 08 07 00 02 07 00 91 07 00 66 07 00 91 07 00 94 07 00 07 04 01 00 00 47 07 00 5C 4E 07 00 E1 06 FF 00 07 00 00 00 01 07 00 33 FF 00 00 00 00 00 01 07 00 84
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  90     397    397    398    Ljava/lang/VirtualMachineError;
            //  90     135    366    381    Ljava/lang/NullPointerException;
            //  141    358    366    381    Ljava/lang/NullPointerException;
            //  90     135    381    388    Ljava/lang/Exception;
            //  141    358    381    388    Ljava/lang/Exception;
            //  0      396    396    397    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0141:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public String toBundleName(final String str, final Locale locale) {
            try {
                final Locale root = Locale.ROOT;
                BytecodeManager.incBytecodes(3);
                if (locale == root) {
                    BytecodeManager.incBytecodes(2);
                    return str;
                }
                BytecodeManager.incBytecodes(2);
                final String language = locale.getLanguage();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final String script = locale.getScript();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final String country = locale.getCountry();
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(2);
                final String variant = locale.getVariant();
                BytecodeManager.incBytecodes(1);
                final String s = language;
                final String s2 = "";
                BytecodeManager.incBytecodes(3);
                if (s == s2) {
                    final String s3 = country;
                    final String s4 = "";
                    BytecodeManager.incBytecodes(3);
                    if (s3 == s4) {
                        final String s5 = variant;
                        final String s6 = "";
                        BytecodeManager.incBytecodes(3);
                        if (s5 == s6) {
                            BytecodeManager.incBytecodes(2);
                            return str;
                        }
                    }
                }
                BytecodeManager.incBytecodes(4);
                final StringBuilder sb = new StringBuilder(str);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final char c = '_';
                BytecodeManager.incBytecodes(3);
                sb2.append(c);
                BytecodeManager.incBytecodes(1);
                final String s7 = script;
                final String s8 = "";
                BytecodeManager.incBytecodes(3);
                if (s7 != s8) {
                    final String s9 = variant;
                    final String s10 = "";
                    BytecodeManager.incBytecodes(3);
                    if (s9 != s10) {
                        final StringBuilder sb3 = sb;
                        final String str2 = language;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append = sb3.append(str2);
                        final char c2 = '_';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append2 = append.append(c2);
                        final String str3 = script;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append3 = append2.append(str3);
                        final char c3 = '_';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append4 = append3.append(c3);
                        final String str4 = country;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append5 = append4.append(str4);
                        final char c4 = '_';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append6 = append5.append(c4);
                        final String str5 = variant;
                        BytecodeManager.incBytecodes(2);
                        append6.append(str5);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final String s11 = country;
                        final String s12 = "";
                        BytecodeManager.incBytecodes(3);
                        if (s11 != s12) {
                            final StringBuilder sb4 = sb;
                            final String str6 = language;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append7 = sb4.append(str6);
                            final char c5 = '_';
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append8 = append7.append(c5);
                            final String str7 = script;
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append9 = append8.append(str7);
                            final char c6 = '_';
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append10 = append9.append(c6);
                            final String str8 = country;
                            BytecodeManager.incBytecodes(2);
                            append10.append(str8);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final StringBuilder sb5 = sb;
                            final String str9 = language;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append11 = sb5.append(str9);
                            final char c7 = '_';
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append12 = append11.append(c7);
                            final String str10 = script;
                            BytecodeManager.incBytecodes(2);
                            append12.append(str10);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                }
                else {
                    final String s13 = variant;
                    final String s14 = "";
                    BytecodeManager.incBytecodes(3);
                    if (s13 != s14) {
                        final StringBuilder sb6 = sb;
                        final String str11 = language;
                        BytecodeManager.incBytecodes(3);
                        final StringBuilder append13 = sb6.append(str11);
                        final char c8 = '_';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append14 = append13.append(c8);
                        final String str12 = country;
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append15 = append14.append(str12);
                        final char c9 = '_';
                        BytecodeManager.incBytecodes(2);
                        final StringBuilder append16 = append15.append(c9);
                        final String str13 = variant;
                        BytecodeManager.incBytecodes(2);
                        append16.append(str13);
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        final String s15 = country;
                        final String s16 = "";
                        BytecodeManager.incBytecodes(3);
                        if (s15 != s16) {
                            final StringBuilder sb7 = sb;
                            final String str14 = language;
                            BytecodeManager.incBytecodes(3);
                            final StringBuilder append17 = sb7.append(str14);
                            final char c10 = '_';
                            BytecodeManager.incBytecodes(2);
                            final StringBuilder append18 = append17.append(c10);
                            final String str15 = country;
                            BytecodeManager.incBytecodes(2);
                            append18.append(str15);
                            BytecodeManager.incBytecodes(2);
                        }
                        else {
                            final StringBuilder sb8 = sb;
                            final String str16 = language;
                            BytecodeManager.incBytecodes(3);
                            sb8.append(str16);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                }
                final StringBuilder sb9 = sb;
                BytecodeManager.incBytecodes(2);
                final String string = sb9.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final String toResourceName(final String s, final String str) {
            try {
                BytecodeManager.incBytecodes(4);
                final int n = s.length() + 1;
                BytecodeManager.incBytecodes(4);
                final int capacity = n + str.length();
                BytecodeManager.incBytecodes(2);
                final StringBuilder sb = new StringBuilder(capacity);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb2 = sb;
                final char oldChar = '.';
                final char newChar = '/';
                BytecodeManager.incBytecodes(5);
                final String replace = s.replace(oldChar, newChar);
                BytecodeManager.incBytecodes(1);
                final StringBuilder append = sb2.append(replace);
                final char c = '.';
                BytecodeManager.incBytecodes(2);
                final StringBuilder append2 = append.append(c);
                BytecodeManager.incBytecodes(2);
                append2.append(str);
                BytecodeManager.incBytecodes(1);
                final StringBuilder sb3 = sb;
                BytecodeManager.incBytecodes(2);
                final String string = sb3.toString();
                BytecodeManager.incBytecodes(1);
                return string;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private String toResourceName0(final String s, final String s2) {
            try {
                final String s3 = "://";
                BytecodeManager.incBytecodes(3);
                final boolean contains = s.contains(s3);
                BytecodeManager.incBytecodes(1);
                if (contains) {
                    final String s4 = null;
                    BytecodeManager.incBytecodes(2);
                    return s4;
                }
                BytecodeManager.incBytecodes(4);
                final String resourceName = this.toResourceName(s, s2);
                BytecodeManager.incBytecodes(1);
                return resourceName;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$300() {
            try {
                final Control instance = Control.INSTANCE;
                BytecodeManager.incBytecodes(2);
                return instance;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final String[] array = { "java.class", "java.properties" };
                BytecodeManager.incBytecodes(9);
                BytecodeManager.incBytecodes(1);
                final List<String> list = Arrays.asList(array);
                BytecodeManager.incBytecodes(1);
                FORMAT_DEFAULT = Collections.unmodifiableList((List<?>)list);
                BytecodeManager.incBytecodes(1);
                final String[] array2 = { "java.class" };
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final List<String> list2 = Arrays.asList(array2);
                BytecodeManager.incBytecodes(1);
                FORMAT_CLASS = Collections.unmodifiableList((List<?>)list2);
                BytecodeManager.incBytecodes(1);
                final String[] array3 = { "java.properties" };
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
                final List<String> list3 = Arrays.asList(array3);
                BytecodeManager.incBytecodes(1);
                FORMAT_PROPERTIES = Collections.unmodifiableList((List<?>)list3);
                BytecodeManager.incBytecodes(1);
                BytecodeManager.incBytecodes(3);
                INSTANCE = new Control();
                BytecodeManager.incBytecodes(1);
                final ResourceBundle resourceBundle = null;
                BytecodeManager.incBytecodes(4);
                CANDIDATES_CACHE = new CandidateListCache();
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        private static class CandidateListCache extends LocaleObjectCache<BaseLocale, List<Locale>>
        {
            private CandidateListCache() {
                try {
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(1);
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            @Override
            protected List<Locale> createObject(final BaseLocale baseLocale) {
                try {
                    BytecodeManager.incBytecodes(2);
                    final String language = baseLocale.getLanguage();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    String script = baseLocale.getScript();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    String region = baseLocale.getRegion();
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(2);
                    String variant = baseLocale.getVariant();
                    BytecodeManager.incBytecodes(1);
                    boolean b = false;
                    BytecodeManager.incBytecodes(2);
                    boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    final String s = language;
                    final String anObject = "no";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals = s.equals(anObject);
                    BytecodeManager.incBytecodes(1);
                    Label_0165: {
                        if (equals) {
                            final String s2 = region;
                            final String anObject2 = "NO";
                            BytecodeManager.incBytecodes(3);
                            final boolean equals2 = s2.equals(anObject2);
                            BytecodeManager.incBytecodes(1);
                            if (equals2) {
                                final String s3 = variant;
                                final String anObject3 = "NY";
                                BytecodeManager.incBytecodes(3);
                                final boolean equals3 = s3.equals(anObject3);
                                BytecodeManager.incBytecodes(1);
                                if (equals3) {
                                    variant = "";
                                    BytecodeManager.incBytecodes(2);
                                    b2 = true;
                                    BytecodeManager.incBytecodes(3);
                                    break Label_0165;
                                }
                            }
                            b = true;
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    final String s4 = language;
                    final String anObject4 = "nb";
                    BytecodeManager.incBytecodes(3);
                    final boolean equals4 = s4.equals(anObject4);
                    BytecodeManager.incBytecodes(1);
                    if (!equals4) {
                        final boolean b3 = b;
                        BytecodeManager.incBytecodes(2);
                        if (!b3) {
                            final String s5 = language;
                            final String anObject5 = "nn";
                            BytecodeManager.incBytecodes(3);
                            final boolean equals5 = s5.equals(anObject5);
                            BytecodeManager.incBytecodes(1);
                            if (!equals5) {
                                final boolean b4 = b2;
                                BytecodeManager.incBytecodes(2);
                                if (!b4) {
                                    final String s6 = language;
                                    final String anObject6 = "zh";
                                    BytecodeManager.incBytecodes(3);
                                    final boolean equals6 = s6.equals(anObject6);
                                    BytecodeManager.incBytecodes(1);
                                    Label_1162: {
                                        if (equals6) {
                                            final String s7 = script;
                                            BytecodeManager.incBytecodes(2);
                                            final int length = s7.length();
                                            BytecodeManager.incBytecodes(1);
                                            if (length == 0) {
                                                final String s8 = region;
                                                BytecodeManager.incBytecodes(2);
                                                final int length2 = s8.length();
                                                BytecodeManager.incBytecodes(1);
                                                if (length2 > 0) {
                                                    final String s9 = region;
                                                    int n = -1;
                                                    final String s10 = s9;
                                                    BytecodeManager.incBytecodes(6);
                                                    final int hashCode = s10.hashCode();
                                                    BytecodeManager.incBytecodes(1);
                                                    switch (hashCode) {
                                                        case 2691: {
                                                            final String s11 = s9;
                                                            final String anObject7 = "TW";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals7 = s11.equals(anObject7);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals7) {
                                                                n = 0;
                                                                BytecodeManager.incBytecodes(3);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        case 2307: {
                                                            final String s12 = s9;
                                                            final String anObject8 = "HK";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals8 = s12.equals(anObject8);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals8) {
                                                                n = 1;
                                                                BytecodeManager.incBytecodes(3);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        case 2466: {
                                                            final String s13 = s9;
                                                            final String anObject9 = "MO";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals9 = s13.equals(anObject9);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals9) {
                                                                n = 2;
                                                                BytecodeManager.incBytecodes(3);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        case 2155: {
                                                            final String s14 = s9;
                                                            final String anObject10 = "CN";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals10 = s14.equals(anObject10);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals10) {
                                                                n = 3;
                                                                BytecodeManager.incBytecodes(3);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        case 2644: {
                                                            final String s15 = s9;
                                                            final String anObject11 = "SG";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals11 = s15.equals(anObject11);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals11) {
                                                                n = 4;
                                                                BytecodeManager.incBytecodes(2);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    final int n2 = n;
                                                    BytecodeManager.incBytecodes(2);
                                                    switch (n2) {
                                                        case 0:
                                                        case 1:
                                                        case 2: {
                                                            script = "Hant";
                                                            BytecodeManager.incBytecodes(2);
                                                            BytecodeManager.incBytecodes(1);
                                                            break;
                                                        }
                                                        case 3:
                                                        case 4: {
                                                            script = "Hans";
                                                            BytecodeManager.incBytecodes(2);
                                                            break;
                                                        }
                                                    }
                                                    BytecodeManager.incBytecodes(1);
                                                    break Label_1162;
                                                }
                                            }
                                            final String s16 = script;
                                            BytecodeManager.incBytecodes(2);
                                            final int length3 = s16.length();
                                            BytecodeManager.incBytecodes(1);
                                            if (length3 > 0) {
                                                final String s17 = region;
                                                BytecodeManager.incBytecodes(2);
                                                final int length4 = s17.length();
                                                BytecodeManager.incBytecodes(1);
                                                if (length4 == 0) {
                                                    final String s18 = script;
                                                    int n3 = -1;
                                                    final String s19 = s18;
                                                    BytecodeManager.incBytecodes(6);
                                                    final int hashCode2 = s19.hashCode();
                                                    BytecodeManager.incBytecodes(1);
                                                    switch (hashCode2) {
                                                        case 2241694: {
                                                            final String s20 = s18;
                                                            final String anObject12 = "Hans";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals12 = s20.equals(anObject12);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals12) {
                                                                n3 = 0;
                                                                BytecodeManager.incBytecodes(3);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        case 2241695: {
                                                            final String s21 = s18;
                                                            final String anObject13 = "Hant";
                                                            BytecodeManager.incBytecodes(3);
                                                            final boolean equals13 = s21.equals(anObject13);
                                                            BytecodeManager.incBytecodes(1);
                                                            if (equals13) {
                                                                n3 = 1;
                                                                BytecodeManager.incBytecodes(2);
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    final int n4 = n3;
                                                    BytecodeManager.incBytecodes(2);
                                                    switch (n4) {
                                                        case 0: {
                                                            region = "CN";
                                                            BytecodeManager.incBytecodes(2);
                                                            BytecodeManager.incBytecodes(1);
                                                            break;
                                                        }
                                                        case 1: {
                                                            region = "TW";
                                                            BytecodeManager.incBytecodes(2);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    final String s22 = language;
                                    final String s23 = script;
                                    final String s24 = region;
                                    final String s25 = variant;
                                    BytecodeManager.incBytecodes(5);
                                    final List<Locale> defaultList = getDefaultList(s22, s23, s24, s25);
                                    BytecodeManager.incBytecodes(1);
                                    return defaultList;
                                }
                            }
                            final String s26 = "nn";
                            final String s27 = script;
                            final String s28 = region;
                            final String s29 = variant;
                            BytecodeManager.incBytecodes(5);
                            final List<Locale> defaultList2 = getDefaultList(s26, s27, s28, s29);
                            BytecodeManager.incBytecodes(1);
                            final List<Locale> list = defaultList2;
                            BytecodeManager.incBytecodes(2);
                            int n5 = list.size() - 1;
                            BytecodeManager.incBytecodes(3);
                            final List<Locale> list2 = defaultList2;
                            final int n6 = n5++;
                            final String s30 = "no";
                            final String s31 = "NO";
                            final String s32 = "NY";
                            BytecodeManager.incBytecodes(7);
                            final Locale instance = Locale.getInstance(s30, s31, s32);
                            BytecodeManager.incBytecodes(1);
                            list2.add(n6, instance);
                            final List<Locale> list3 = defaultList2;
                            final int n7 = n5++;
                            final String s33 = "no";
                            final String s34 = "NO";
                            final String s35 = "";
                            BytecodeManager.incBytecodes(7);
                            final Locale instance2 = Locale.getInstance(s33, s34, s35);
                            BytecodeManager.incBytecodes(1);
                            list3.add(n7, instance2);
                            final List<Locale> list4 = defaultList2;
                            final int n8 = n5++;
                            final String s36 = "no";
                            final String s37 = "";
                            final String s38 = "";
                            BytecodeManager.incBytecodes(7);
                            final Locale instance3 = Locale.getInstance(s36, s37, s38);
                            BytecodeManager.incBytecodes(1);
                            list4.add(n8, instance3);
                            final List<Locale> list5 = defaultList2;
                            BytecodeManager.incBytecodes(2);
                            return list5;
                        }
                    }
                    final String s39 = "nb";
                    final String s40 = script;
                    final String s41 = region;
                    final String s42 = variant;
                    BytecodeManager.incBytecodes(5);
                    final List<Locale> defaultList3 = getDefaultList(s39, s40, s41, s42);
                    BytecodeManager.incBytecodes(1);
                    BytecodeManager.incBytecodes(3);
                    final LinkedList<Locale> list6 = new LinkedList<Locale>();
                    BytecodeManager.incBytecodes(1);
                    final List<Locale> list7 = defaultList3;
                    BytecodeManager.incBytecodes(2);
                    final Iterator<Locale> iterator = list7.iterator();
                    BytecodeManager.incBytecodes(1);
                    while (true) {
                        final Iterator<Locale> iterator2 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final boolean hasNext = iterator2.hasNext();
                        BytecodeManager.incBytecodes(1);
                        if (!hasNext) {
                            break;
                        }
                        final Iterator<Locale> iterator3 = iterator;
                        BytecodeManager.incBytecodes(2);
                        final Locale locale = iterator3.next();
                        BytecodeManager.incBytecodes(2);
                        final LinkedList<Locale> list8 = list6;
                        final Locale locale2 = locale;
                        BytecodeManager.incBytecodes(3);
                        list8.add(locale2);
                        BytecodeManager.incBytecodes(1);
                        final Locale locale3 = locale;
                        BytecodeManager.incBytecodes(2);
                        final String language2 = locale3.getLanguage();
                        BytecodeManager.incBytecodes(1);
                        final int length5 = language2.length();
                        BytecodeManager.incBytecodes(1);
                        if (length5 == 0) {
                            BytecodeManager.incBytecodes(1);
                            break;
                        }
                        final LinkedList<Locale> list9 = list6;
                        final String s43 = "no";
                        final Locale locale4 = locale;
                        BytecodeManager.incBytecodes(4);
                        final String script2 = locale4.getScript();
                        final Locale locale5 = locale;
                        BytecodeManager.incBytecodes(2);
                        final String country = locale5.getCountry();
                        final Locale locale6 = locale;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final String variant2 = locale6.getVariant();
                        final LocaleExtensions localeExtensions = null;
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                        final Locale instance4 = Locale.getInstance(s43, script2, country, variant2, localeExtensions);
                        BytecodeManager.incBytecodes(1);
                        list9.add(instance4);
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(1);
                    }
                    final LinkedList<Locale> list10 = list6;
                    BytecodeManager.incBytecodes(2);
                    return list10;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
            
            private static List<Locale> getDefaultList(final String s, final String s2, final String s3, final String s4) {
                try {
                    List<String> list = null;
                    BytecodeManager.incBytecodes(2);
                    BytecodeManager.incBytecodes(2);
                    final int length = s4.length();
                    BytecodeManager.incBytecodes(1);
                    if (length > 0) {
                        BytecodeManager.incBytecodes(3);
                        list = new LinkedList<String>();
                        BytecodeManager.incBytecodes(1);
                        BytecodeManager.incBytecodes(2);
                        int n = s4.length();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final int n2 = n;
                            final int n3 = -1;
                            BytecodeManager.incBytecodes(3);
                            if (n2 == n3) {
                                break;
                            }
                            final List<String> list2 = list;
                            final int beginIndex = 0;
                            final int endIndex = n;
                            BytecodeManager.incBytecodes(5);
                            final String substring = s4.substring(beginIndex, endIndex);
                            BytecodeManager.incBytecodes(1);
                            list2.add(substring);
                            BytecodeManager.incBytecodes(1);
                            final int ch = 95;
                            final int fromIndex = --n;
                            BytecodeManager.incBytecodes(5);
                            n = s4.lastIndexOf(ch, fromIndex);
                            BytecodeManager.incBytecodes(2);
                        }
                    }
                    BytecodeManager.incBytecodes(3);
                    final LinkedList<Locale> list3 = new LinkedList<Locale>();
                    BytecodeManager.incBytecodes(1);
                    final List<String> list4 = list;
                    BytecodeManager.incBytecodes(2);
                    if (list4 != null) {
                        final List<String> list5 = list;
                        BytecodeManager.incBytecodes(2);
                        final Iterator<String> iterator = list5.iterator();
                        BytecodeManager.incBytecodes(1);
                        while (true) {
                            final Iterator<String> iterator2 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final boolean hasNext = iterator2.hasNext();
                            BytecodeManager.incBytecodes(1);
                            if (!hasNext) {
                                break;
                            }
                            final Iterator<String> iterator3 = iterator;
                            BytecodeManager.incBytecodes(2);
                            final String s5 = iterator3.next();
                            BytecodeManager.incBytecodes(2);
                            final LinkedList<Locale> list6 = list3;
                            final String s6 = s5;
                            final LocaleExtensions localeExtensions = null;
                            BytecodeManager.incBytecodes(7);
                            final Locale instance = Locale.getInstance(s, s2, s3, s6, localeExtensions);
                            BytecodeManager.incBytecodes(1);
                            list6.add(instance);
                            BytecodeManager.incBytecodes(1);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final int length2 = s3.length();
                    BytecodeManager.incBytecodes(1);
                    if (length2 > 0) {
                        final LinkedList<Locale> list7 = list3;
                        final String s7 = "";
                        final LocaleExtensions localeExtensions2 = null;
                        BytecodeManager.incBytecodes(7);
                        final Locale instance2 = Locale.getInstance(s, s2, s3, s7, localeExtensions2);
                        BytecodeManager.incBytecodes(1);
                        list7.add(instance2);
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(2);
                    final int length3 = s2.length();
                    BytecodeManager.incBytecodes(1);
                    if (length3 > 0) {
                        final LinkedList<Locale> list8 = list3;
                        final String s8 = "";
                        final String s9 = "";
                        final LocaleExtensions localeExtensions3 = null;
                        BytecodeManager.incBytecodes(7);
                        final Locale instance3 = Locale.getInstance(s, s2, s8, s9, localeExtensions3);
                        BytecodeManager.incBytecodes(1);
                        list8.add(instance3);
                        BytecodeManager.incBytecodes(1);
                        final List<String> list9 = list;
                        BytecodeManager.incBytecodes(2);
                        if (list9 != null) {
                            final List<String> list10 = list;
                            BytecodeManager.incBytecodes(2);
                            final Iterator<String> iterator4 = list10.iterator();
                            BytecodeManager.incBytecodes(1);
                            while (true) {
                                final Iterator<String> iterator5 = iterator4;
                                BytecodeManager.incBytecodes(2);
                                final boolean hasNext2 = iterator5.hasNext();
                                BytecodeManager.incBytecodes(1);
                                if (!hasNext2) {
                                    break;
                                }
                                final Iterator<String> iterator6 = iterator4;
                                BytecodeManager.incBytecodes(2);
                                final String s10 = iterator6.next();
                                BytecodeManager.incBytecodes(2);
                                final LinkedList<Locale> list11 = list3;
                                final String s11 = "";
                                final String s12 = s10;
                                final LocaleExtensions localeExtensions4 = null;
                                BytecodeManager.incBytecodes(7);
                                final Locale instance4 = Locale.getInstance(s, s11, s3, s12, localeExtensions4);
                                BytecodeManager.incBytecodes(1);
                                list11.add(instance4);
                                BytecodeManager.incBytecodes(1);
                                BytecodeManager.incBytecodes(1);
                            }
                        }
                        BytecodeManager.incBytecodes(2);
                        final int length4 = s3.length();
                        BytecodeManager.incBytecodes(1);
                        if (length4 > 0) {
                            final LinkedList<Locale> list12 = list3;
                            final String s13 = "";
                            final String s14 = "";
                            final LocaleExtensions localeExtensions5 = null;
                            BytecodeManager.incBytecodes(7);
                            final Locale instance5 = Locale.getInstance(s, s13, s3, s14, localeExtensions5);
                            BytecodeManager.incBytecodes(1);
                            list12.add(instance5);
                            BytecodeManager.incBytecodes(1);
                        }
                    }
                    BytecodeManager.incBytecodes(2);
                    final int length5 = s.length();
                    BytecodeManager.incBytecodes(1);
                    if (length5 > 0) {
                        final LinkedList<Locale> list13 = list3;
                        final String s15 = "";
                        final String s16 = "";
                        final String s17 = "";
                        final LocaleExtensions localeExtensions6 = null;
                        BytecodeManager.incBytecodes(7);
                        final Locale instance6 = Locale.getInstance(s, s15, s16, s17, localeExtensions6);
                        BytecodeManager.incBytecodes(1);
                        list13.add(instance6);
                        BytecodeManager.incBytecodes(1);
                    }
                    final LinkedList<Locale> list14 = list3;
                    final Locale root = Locale.ROOT;
                    BytecodeManager.incBytecodes(3);
                    list14.add(root);
                    BytecodeManager.incBytecodes(1);
                    final LinkedList<Locale> list15 = list3;
                    BytecodeManager.incBytecodes(2);
                    return list15;
                }
                finally {
                    throw loadexception(java.lang.Throwable.class);
                }
            }
        }
    }
    
    private static class SingleFormatControl extends Control
    {
        private static final Control PROPERTIES_ONLY;
        private static final Control CLASS_ONLY;
        private final List<String> formats;
        
        protected SingleFormatControl(final List<String> formats) {
            try {
                BytecodeManager.incBytecodes(2);
                this.formats = formats;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public List<String> getFormats(final String s) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final List<String> formats = this.formats;
                BytecodeManager.incBytecodes(3);
                return formats;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$800() {
            try {
                final Control properties_ONLY = SingleFormatControl.PROPERTIES_ONLY;
                BytecodeManager.incBytecodes(2);
                return properties_ONLY;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$900() {
            try {
                final Control class_ONLY = SingleFormatControl.CLASS_ONLY;
                BytecodeManager.incBytecodes(2);
                return class_ONLY;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final List<String> format_PROPERTIES = SingleFormatControl.FORMAT_PROPERTIES;
                BytecodeManager.incBytecodes(4);
                PROPERTIES_ONLY = new SingleFormatControl(format_PROPERTIES);
                BytecodeManager.incBytecodes(1);
                final List<String> format_CLASS = SingleFormatControl.FORMAT_CLASS;
                BytecodeManager.incBytecodes(4);
                CLASS_ONLY = new SingleFormatControl(format_CLASS);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private static final class NoFallbackControl extends SingleFormatControl
    {
        private static final Control NO_FALLBACK;
        private static final Control PROPERTIES_ONLY_NO_FALLBACK;
        private static final Control CLASS_ONLY_NO_FALLBACK;
        
        protected NoFallbackControl(final List<String> list) {
            try {
                BytecodeManager.incBytecodes(3);
                super(list);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public Locale getFallbackLocale(final String s, final Locale locale) {
            try {
                BytecodeManager.incBytecodes(2);
                if (s != null) {
                    BytecodeManager.incBytecodes(2);
                    if (locale != null) {
                        final Locale locale2 = null;
                        BytecodeManager.incBytecodes(2);
                        return locale2;
                    }
                }
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$1000() {
            try {
                final Control no_FALLBACK = NoFallbackControl.NO_FALLBACK;
                BytecodeManager.incBytecodes(2);
                return no_FALLBACK;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$1100() {
            try {
                final Control properties_ONLY_NO_FALLBACK = NoFallbackControl.PROPERTIES_ONLY_NO_FALLBACK;
                BytecodeManager.incBytecodes(2);
                return properties_ONLY_NO_FALLBACK;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static /* synthetic */ Control access$1200() {
            try {
                final Control class_ONLY_NO_FALLBACK = NoFallbackControl.CLASS_ONLY_NO_FALLBACK;
                BytecodeManager.incBytecodes(2);
                return class_ONLY_NO_FALLBACK;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        static {
            try {
                final List<String> format_DEFAULT = NoFallbackControl.FORMAT_DEFAULT;
                BytecodeManager.incBytecodes(4);
                NO_FALLBACK = new NoFallbackControl(format_DEFAULT);
                BytecodeManager.incBytecodes(1);
                final List<String> format_PROPERTIES = NoFallbackControl.FORMAT_PROPERTIES;
                BytecodeManager.incBytecodes(4);
                PROPERTIES_ONLY_NO_FALLBACK = new NoFallbackControl(format_PROPERTIES);
                BytecodeManager.incBytecodes(1);
                final List<String> format_CLASS = NoFallbackControl.FORMAT_CLASS;
                BytecodeManager.incBytecodes(4);
                CLASS_ONLY_NO_FALLBACK = new NoFallbackControl(format_CLASS);
                BytecodeManager.incBytecodes(2);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    private interface CacheKeyReference
    {
        CacheKey getCacheKey();
    }
}
