// 
// Decompiled by Procyon v0.5.36
// 

package instrumented.java.util;

import instrumented.java.util.function.Consumer;
import java.util.Iterator;
import instrumented.java.util.function.BiFunction;
import instrumented.java.util.function.BiConsumer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import aic2021.engine.BytecodeManager;

public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V>
{
    private static final long serialVersionUID = 3801124242820219131L;
    transient Entry<K, V> head;
    transient Entry<K, V> tail;
    final boolean accessOrder;
    
    private void linkNodeLast(final Entry<K, V> after) {
        try {
            final Entry<K, V> tail = this.tail;
            BytecodeManager.incBytecodes(3);
            this.tail = after;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> entry = tail;
            BytecodeManager.incBytecodes(2);
            if (entry == null) {
                this.head = after;
                BytecodeManager.incBytecodes(4);
            }
            else {
                after.before = tail;
                BytecodeManager.incBytecodes(3);
                tail.after = after;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    private void transferLinks(final Entry<K, V> entry, final Entry<K, V> entry2) {
        try {
            final Entry<K, V> before = entry.before;
            entry2.before = before;
            final Entry<K, V> entry3 = before;
            BytecodeManager.incBytecodes(6);
            final Entry<K, V> after = entry.after;
            entry2.after = after;
            final Entry<K, V> entry4 = after;
            BytecodeManager.incBytecodes(6);
            final Entry<K, V> entry5 = entry3;
            BytecodeManager.incBytecodes(2);
            if (entry5 == null) {
                this.head = entry2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                entry3.after = entry2;
                BytecodeManager.incBytecodes(3);
            }
            final Entry<K, V> entry6 = entry4;
            BytecodeManager.incBytecodes(2);
            if (entry6 == null) {
                this.tail = entry2;
                BytecodeManager.incBytecodes(4);
            }
            else {
                entry4.before = entry2;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void reinitialize() {
        try {
            BytecodeManager.incBytecodes(2);
            super.reinitialize();
            final Entry<K, V> entry = null;
            this.tail = entry;
            this.head = entry;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    Node<K, V> newNode(final int n, final K k, final V v, final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(7);
            final Entry<K, V> entry = new Entry<K, V>(n, k, v, node);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = entry;
            BytecodeManager.incBytecodes(3);
            this.linkNodeLast(entry2);
            final Entry<K, V> entry3 = entry;
            BytecodeManager.incBytecodes(2);
            return entry3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    Node<K, V> replacementNode(final Node<K, V> node, final Node<K, V> node2) {
        try {
            final Entry entry = (Entry<K, V>)node;
            BytecodeManager.incBytecodes(3);
            final int hash = entry.hash;
            final K key = (K)entry.key;
            final V value = (V)entry.value;
            BytecodeManager.incBytecodes(10);
            final Entry entry2 = new Entry<K, V>(hash, key, value, node2);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry3 = (Entry<K, V>)entry;
            final Entry entry4 = entry2;
            BytecodeManager.incBytecodes(4);
            this.transferLinks(entry3, entry4);
            final Entry entry5 = entry2;
            BytecodeManager.incBytecodes(2);
            return (Node<K, V>)entry5;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    TreeNode<K, V> newTreeNode(final int n, final K k, final V v, final Node<K, V> node) {
        try {
            BytecodeManager.incBytecodes(7);
            final TreeNode<K, V> treeNode = new TreeNode<K, V>(n, k, v, node);
            BytecodeManager.incBytecodes(1);
            final TreeNode<K, V> treeNode2 = treeNode;
            BytecodeManager.incBytecodes(3);
            this.linkNodeLast(treeNode2);
            final TreeNode<K, V> treeNode3 = treeNode;
            BytecodeManager.incBytecodes(2);
            return treeNode3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    TreeNode<K, V> replacementTreeNode(final Node<K, V> node, final Node<K, V> node2) {
        try {
            final Entry entry = (Entry<K, V>)node;
            BytecodeManager.incBytecodes(3);
            final int hash = entry.hash;
            final K key = (K)entry.key;
            final V value = (V)entry.value;
            BytecodeManager.incBytecodes(10);
            final TreeNode treeNode = new TreeNode<K, V>(hash, key, value, node2);
            BytecodeManager.incBytecodes(1);
            final Entry<K, V> entry2 = (Entry<K, V>)entry;
            final TreeNode treeNode2 = treeNode;
            BytecodeManager.incBytecodes(4);
            this.transferLinks(entry2, treeNode2);
            final TreeNode treeNode3 = treeNode;
            BytecodeManager.incBytecodes(2);
            return (TreeNode<K, V>)treeNode3;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void afterNodeRemoval(final Node<K, V> node) {
        try {
            final Entry entry = (Entry)node;
            BytecodeManager.incBytecodes(3);
            final Entry<K, V> before = entry.before;
            final Entry<K, V> after = entry.after;
            BytecodeManager.incBytecodes(6);
            final Entry entry2 = entry;
            final Entry entry3 = entry;
            final Entry<K, V> entry4 = null;
            entry3.after = entry4;
            entry2.before = entry4;
            BytecodeManager.incBytecodes(6);
            final Entry<K, V> entry5 = before;
            BytecodeManager.incBytecodes(2);
            if (entry5 == null) {
                this.head = (Entry<K, V>)after;
                BytecodeManager.incBytecodes(4);
            }
            else {
                before.after = after;
                BytecodeManager.incBytecodes(3);
            }
            final Entry<K, V> entry6 = (Entry<K, V>)after;
            BytecodeManager.incBytecodes(2);
            if (entry6 == null) {
                this.tail = (Entry<K, V>)before;
                BytecodeManager.incBytecodes(4);
            }
            else {
                after.before = before;
                BytecodeManager.incBytecodes(3);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void afterNodeInsertion(final boolean b) {
        try {
            BytecodeManager.incBytecodes(2);
            if (b) {
                final Entry<K, V> head;
                final Entry<K, V> entry = head = this.head;
                BytecodeManager.incBytecodes(5);
                if (entry != null) {
                    final Entry<K, V> entry2 = head;
                    BytecodeManager.incBytecodes(3);
                    final boolean removeEldestEntry = this.removeEldestEntry(entry2);
                    BytecodeManager.incBytecodes(1);
                    if (removeEldestEntry) {
                        final K key = head.key;
                        BytecodeManager.incBytecodes(3);
                        final K k = key;
                        BytecodeManager.incBytecodes(3);
                        final int hash = HashMap.hash(k);
                        final K i = key;
                        final Object o = null;
                        final boolean b2 = false;
                        final boolean b3 = true;
                        BytecodeManager.incBytecodes(5);
                        this.removeNode(hash, i, o, b2, b3);
                        BytecodeManager.incBytecodes(1);
                    }
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void afterNodeAccess(final Node<K, V> node) {
        try {
            final boolean accessOrder = this.accessOrder;
            BytecodeManager.incBytecodes(3);
            if (accessOrder) {
                Entry<K, V> tail;
                final Entry<K, V> entry = tail = this.tail;
                BytecodeManager.incBytecodes(6);
                if (entry != node) {
                    final Entry<K, V> tail2 = (Entry<K, V>)node;
                    BytecodeManager.incBytecodes(3);
                    final Entry<K, V> before = tail2.before;
                    final Entry<K, V> after = tail2.after;
                    BytecodeManager.incBytecodes(6);
                    tail2.after = null;
                    BytecodeManager.incBytecodes(3);
                    final Entry<K, V> entry2 = before;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        this.head = after;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        before.after = after;
                        BytecodeManager.incBytecodes(3);
                    }
                    final Entry<K, V> entry3 = after;
                    BytecodeManager.incBytecodes(2);
                    if (entry3 != null) {
                        after.before = before;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        tail = before;
                        BytecodeManager.incBytecodes(2);
                    }
                    final Entry<K, V> entry4 = tail;
                    BytecodeManager.incBytecodes(2);
                    if (entry4 == null) {
                        this.head = tail2;
                        BytecodeManager.incBytecodes(4);
                    }
                    else {
                        tail2.before = tail;
                        BytecodeManager.incBytecodes(3);
                        tail.after = tail2;
                        BytecodeManager.incBytecodes(3);
                    }
                    this.tail = tail2;
                    BytecodeManager.incBytecodes(3);
                    ++this.modCount;
                    BytecodeManager.incBytecodes(6);
                }
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    void internalWriteEntries(final ObjectOutputStream objectOutputStream) throws IOException {
        try {
            Entry<K, V> entry = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    break;
                }
                final K key = entry.key;
                BytecodeManager.incBytecodes(4);
                objectOutputStream.writeObject(key);
                final V value = entry.value;
                BytecodeManager.incBytecodes(4);
                objectOutputStream.writeObject(value);
                entry = entry.after;
                BytecodeManager.incBytecodes(4);
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashMap(final int n, final float n2) {
        try {
            BytecodeManager.incBytecodes(4);
            super(n, n2);
            this.accessOrder = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashMap(final int n) {
        try {
            BytecodeManager.incBytecodes(3);
            super(n);
            this.accessOrder = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashMap() {
        try {
            BytecodeManager.incBytecodes(2);
            this.accessOrder = false;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashMap(final Map<? extends K, ? extends V> map) {
        try {
            BytecodeManager.incBytecodes(2);
            this.accessOrder = false;
            BytecodeManager.incBytecodes(3);
            final boolean b = false;
            BytecodeManager.incBytecodes(4);
            this.putMapEntries(map, b);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    public LinkedHashMap(final int n, final float n2, final boolean accessOrder) {
        try {
            BytecodeManager.incBytecodes(4);
            super(n, n2);
            this.accessOrder = accessOrder;
            BytecodeManager.incBytecodes(3);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        try {
            Entry<K, V> entry = this.head;
            BytecodeManager.incBytecodes(3);
            Label_0086: {
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break Label_0086;
                    }
                    final V value = entry.value;
                    BytecodeManager.incBytecodes(3);
                    final V v = value;
                    BytecodeManager.incBytecodes(3);
                    if (v == o) {
                        break;
                    }
                    BytecodeManager.incBytecodes(2);
                    if (o != null) {
                        final V obj = value;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = o.equals(obj);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            break;
                        }
                    }
                    entry = entry.after;
                    BytecodeManager.incBytecodes(4);
                }
                final boolean b = true;
                BytecodeManager.incBytecodes(2);
                return b;
            }
            final boolean b2 = false;
            BytecodeManager.incBytecodes(2);
            return b2;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V get(final Object o) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = HashMap.hash(o);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node2;
            final Node<K, V> node = node2 = this.getNode(hash, o);
            BytecodeManager.incBytecodes(3);
            if (node == null) {
                final V v = null;
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final boolean accessOrder = this.accessOrder;
            BytecodeManager.incBytecodes(3);
            if (accessOrder) {
                final Node<K, V> node3 = node2;
                BytecodeManager.incBytecodes(3);
                this.afterNodeAccess(node3);
            }
            final V value = node2.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public V getOrDefault(final Object o, final V v) {
        try {
            BytecodeManager.incBytecodes(3);
            final int hash = HashMap.hash(o);
            BytecodeManager.incBytecodes(2);
            final Node<K, V> node2;
            final Node<K, V> node = node2 = this.getNode(hash, o);
            BytecodeManager.incBytecodes(3);
            if (node == null) {
                BytecodeManager.incBytecodes(2);
                return v;
            }
            final boolean accessOrder = this.accessOrder;
            BytecodeManager.incBytecodes(3);
            if (accessOrder) {
                final Node<K, V> node3 = node2;
                BytecodeManager.incBytecodes(3);
                this.afterNodeAccess(node3);
            }
            final V value = node2.value;
            BytecodeManager.incBytecodes(3);
            return value;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void clear() {
        try {
            BytecodeManager.incBytecodes(2);
            super.clear();
            final Entry<K, V> entry = null;
            this.tail = entry;
            this.head = entry;
            BytecodeManager.incBytecodes(6);
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    protected boolean removeEldestEntry(final Map.Entry<K, V> entry) {
        try {
            final boolean b = false;
            BytecodeManager.incBytecodes(2);
            return b;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<K> keySet() {
        try {
            final Set<K> keySet = this.keySet;
            BytecodeManager.incBytecodes(5);
            Set<K> set;
            if (keySet == null) {
                final LinkedKeySet keySet2 = (LinkedKeySet)(set = new LinkedKeySet());
                BytecodeManager.incBytecodes(5);
                this.keySet = keySet2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                set = keySet;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Collection<V> values() {
        try {
            final Collection<V> values = this.values;
            BytecodeManager.incBytecodes(5);
            Collection<V> collection;
            if (values == null) {
                final LinkedValues values2 = (LinkedValues)(collection = new LinkedValues());
                BytecodeManager.incBytecodes(5);
                this.values = values2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                collection = values;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return collection;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        try {
            final Set<Map.Entry<K, V>> entrySet = this.entrySet;
            BytecodeManager.incBytecodes(5);
            Set<Map.Entry<K, V>> set;
            if (entrySet == null) {
                final LinkedEntrySet entrySet2 = (LinkedEntrySet)(set = new LinkedEntrySet());
                BytecodeManager.incBytecodes(5);
                this.entrySet = entrySet2;
                BytecodeManager.incBytecodes(3);
            }
            else {
                set = entrySet;
                BytecodeManager.incBytecodes(1);
            }
            BytecodeManager.incBytecodes(1);
            return set;
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biConsumer == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    break;
                }
                final K key = entry.key;
                final V value = entry.value;
                BytecodeManager.incBytecodes(6);
                biConsumer.accept(key, value);
                entry = entry.after;
                BytecodeManager.incBytecodes(4);
            }
            final int modCount2 = this.modCount;
            final int n = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount2 != n) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    @Override
    public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        try {
            BytecodeManager.incBytecodes(2);
            if (biFunction == null) {
                BytecodeManager.incBytecodes(3);
                final NullPointerException ex = new NullPointerException();
                BytecodeManager.incBytecodes(1);
                throw ex;
            }
            final int modCount = this.modCount;
            BytecodeManager.incBytecodes(3);
            Entry<K, V> entry = this.head;
            BytecodeManager.incBytecodes(3);
            while (true) {
                final Entry<K, V> entry2 = entry;
                BytecodeManager.incBytecodes(2);
                if (entry2 == null) {
                    break;
                }
                final Entry<K, V> entry3 = entry;
                final K key = entry.key;
                final V value = entry.value;
                BytecodeManager.incBytecodes(7);
                entry3.value = (V)biFunction.apply(key, value);
                BytecodeManager.incBytecodes(1);
                entry = entry.after;
                BytecodeManager.incBytecodes(4);
            }
            final int modCount2 = this.modCount;
            final int n = modCount;
            BytecodeManager.incBytecodes(4);
            if (modCount2 != n) {
                BytecodeManager.incBytecodes(3);
                final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                BytecodeManager.incBytecodes(1);
                throw ex2;
            }
            BytecodeManager.incBytecodes(1);
        }
        finally {
            throw loadexception(java.lang.Throwable.class);
        }
    }
    
    static class Entry<K, V> extends Node<K, V>
    {
        Entry<K, V> before;
        Entry<K, V> after;
        
        Entry(final int n, final K k, final V v, final Node<K, V> node) {
            try {
                BytecodeManager.incBytecodes(6);
                super(n, k, v, node);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedKeySet extends AbstractSet<K>
    {
        LinkedKeySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = LinkedHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<K> iterator() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(5);
                final LinkedKeyIterator linkedKeyIterator = this$0.new LinkedKeyIterator();
                BytecodeManager.incBytecodes(1);
                return linkedKeyIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsKey = this$0.containsKey(o);
                BytecodeManager.incBytecodes(1);
                return containsKey;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean remove(final Object o) {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(o);
                final Object o2 = null;
                final boolean b = false;
                final boolean b2 = true;
                BytecodeManager.incBytecodes(5);
                final Node<Object, Object> removeNode = this$0.removeNode(hash, o, o2, b, b2);
                BytecodeManager.incBytecodes(1);
                boolean b3;
                if (removeNode != null) {
                    b3 = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
                    b3 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Spliterator<K> spliterator() {
            try {
                final int n = 81;
                BytecodeManager.incBytecodes(3);
                final Spliterator<Object> spliterator = Spliterators.spliterator((Collection<?>)this, n);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<K>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super K> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = LinkedHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                Entry<K, V> entry = LinkedHashMap.this.head;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break;
                    }
                    final K key = entry.key;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(key);
                    entry = entry.after;
                    BytecodeManager.incBytecodes(4);
                }
                final int modCount2 = LinkedHashMap.this.modCount;
                final int n = modCount;
                BytecodeManager.incBytecodes(5);
                if (modCount2 != n) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedValues extends AbstractCollection<V>
    {
        LinkedValues() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = LinkedHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<V> iterator() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(5);
                final LinkedValueIterator linkedValueIterator = this$0.new LinkedValueIterator();
                BytecodeManager.incBytecodes(1);
                return linkedValueIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(4);
                final boolean containsValue = this$0.containsValue(o);
                BytecodeManager.incBytecodes(1);
                return containsValue;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Spliterator<V> spliterator() {
            try {
                final int n = 80;
                BytecodeManager.incBytecodes(3);
                final Spliterator<Object> spliterator = Spliterators.spliterator((Collection<?>)this, n);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<V>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super V> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = LinkedHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                Entry<K, V> entry = LinkedHashMap.this.head;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break;
                    }
                    final V value = entry.value;
                    BytecodeManager.incBytecodes(4);
                    consumer.accept(value);
                    entry = entry.after;
                    BytecodeManager.incBytecodes(4);
                }
                final int modCount2 = LinkedHashMap.this.modCount;
                final int n = modCount;
                BytecodeManager.incBytecodes(5);
                if (modCount2 != n) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedEntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        LinkedEntrySet() {
            try {
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final int size() {
            try {
                final int size = LinkedHashMap.this.size;
                BytecodeManager.incBytecodes(4);
                return size;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final void clear() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(3);
                this$0.clear();
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Iterator<Map.Entry<K, V>> iterator() {
            try {
                final LinkedHashMap this$0 = LinkedHashMap.this;
                BytecodeManager.incBytecodes(5);
                final LinkedEntryIterator linkedEntryIterator = this$0.new LinkedEntryIterator();
                BytecodeManager.incBytecodes(1);
                return linkedEntryIterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean contains(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (!b) {
                    final boolean b2 = false;
                    BytecodeManager.incBytecodes(2);
                    return b2;
                }
                final Map.Entry entry = (Map.Entry)o;
                BytecodeManager.incBytecodes(3);
                final Map.Entry entry2 = entry;
                BytecodeManager.incBytecodes(2);
                final Object key = entry2.getKey();
                BytecodeManager.incBytecodes(1);
                final LinkedHashMap this$0 = LinkedHashMap.this;
                final Object o2 = key;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(o2);
                final Object o3 = key;
                BytecodeManager.incBytecodes(2);
                final Node<Object, Object> node = this$0.getNode(hash, o3);
                BytecodeManager.incBytecodes(1);
                final Node<Object, Object> node2 = node;
                BytecodeManager.incBytecodes(2);
                boolean b3 = false;
                Label_0119: {
                    if (node2 != null) {
                        final Node<Object, Object> node3 = node;
                        final Map.Entry entry3 = entry;
                        BytecodeManager.incBytecodes(3);
                        final boolean equals = node3.equals(entry3);
                        BytecodeManager.incBytecodes(1);
                        if (equals) {
                            b3 = true;
                            BytecodeManager.incBytecodes(2);
                            break Label_0119;
                        }
                    }
                    b3 = false;
                    BytecodeManager.incBytecodes(1);
                }
                BytecodeManager.incBytecodes(1);
                return b3;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final boolean remove(final Object o) {
            try {
                final boolean b = o instanceof Map.Entry;
                BytecodeManager.incBytecodes(3);
                if (b) {
                    final Map.Entry entry = (Map.Entry)o;
                    BytecodeManager.incBytecodes(3);
                    final Map.Entry entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object key = entry2.getKey();
                    BytecodeManager.incBytecodes(1);
                    final Map.Entry entry3 = entry;
                    BytecodeManager.incBytecodes(2);
                    final Object value = entry3.getValue();
                    BytecodeManager.incBytecodes(1);
                    final LinkedHashMap this$0 = LinkedHashMap.this;
                    final Object o2 = key;
                    BytecodeManager.incBytecodes(4);
                    final int hash = HashMap.hash(o2);
                    final Object o3 = key;
                    final Object o4 = value;
                    final boolean b2 = true;
                    final boolean b3 = true;
                    BytecodeManager.incBytecodes(5);
                    final Node<Object, Object> removeNode = this$0.removeNode(hash, o3, o4, b2, b3);
                    BytecodeManager.incBytecodes(1);
                    boolean b4;
                    if (removeNode != null) {
                        b4 = true;
                        BytecodeManager.incBytecodes(2);
                    }
                    else {
                        b4 = false;
                        BytecodeManager.incBytecodes(1);
                    }
                    BytecodeManager.incBytecodes(1);
                    return b4;
                }
                final boolean b5 = false;
                BytecodeManager.incBytecodes(2);
                return b5;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Spliterator<Map.Entry<K, V>> spliterator() {
            try {
                final int n = 81;
                BytecodeManager.incBytecodes(3);
                final Spliterator<Object> spliterator = Spliterators.spliterator((Collection<?>)this, n);
                BytecodeManager.incBytecodes(1);
                return (Spliterator<Map.Entry<K, V>>)spliterator;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void forEach(final Consumer<? super Map.Entry<K, V>> consumer) {
            try {
                BytecodeManager.incBytecodes(2);
                if (consumer == null) {
                    BytecodeManager.incBytecodes(3);
                    final NullPointerException ex = new NullPointerException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = LinkedHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                Entry<K, V> entry = LinkedHashMap.this.head;
                BytecodeManager.incBytecodes(4);
                while (true) {
                    final Entry<K, V> entry2 = entry;
                    BytecodeManager.incBytecodes(2);
                    if (entry2 == null) {
                        break;
                    }
                    final Entry<K, V> entry3 = entry;
                    BytecodeManager.incBytecodes(3);
                    consumer.accept(entry3);
                    entry = entry.after;
                    BytecodeManager.incBytecodes(4);
                }
                final int modCount2 = LinkedHashMap.this.modCount;
                final int n = modCount;
                BytecodeManager.incBytecodes(5);
                if (modCount2 != n) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    abstract class LinkedHashIterator
    {
        Entry<K, V> next;
        Entry<K, V> current;
        int expectedModCount;
        
        LinkedHashIterator() {
            try {
                BytecodeManager.incBytecodes(5);
                this.next = LinkedHashMap.this.head;
                BytecodeManager.incBytecodes(4);
                this.expectedModCount = LinkedHashMap.this.modCount;
                BytecodeManager.incBytecodes(4);
                this.current = null;
                BytecodeManager.incBytecodes(3);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final boolean hasNext() {
            try {
                final Entry<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                boolean b;
                if (next != null) {
                    b = true;
                    BytecodeManager.incBytecodes(2);
                }
                else {
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
        
        final Entry<K, V> nextNode() {
            try {
                final Entry<K, V> next = this.next;
                BytecodeManager.incBytecodes(3);
                final int modCount = LinkedHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final Entry<K, V> entry = next;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    BytecodeManager.incBytecodes(3);
                    final NoSuchElementException ex2 = new NoSuchElementException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.current = next;
                BytecodeManager.incBytecodes(3);
                this.next = next.after;
                BytecodeManager.incBytecodes(4);
                final Entry<K, V> entry2 = next;
                BytecodeManager.incBytecodes(2);
                return entry2;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        public final void remove() {
            try {
                final Entry<K, V> current = this.current;
                BytecodeManager.incBytecodes(3);
                final Entry<K, V> entry = current;
                BytecodeManager.incBytecodes(2);
                if (entry == null) {
                    BytecodeManager.incBytecodes(3);
                    final IllegalStateException ex = new IllegalStateException();
                    BytecodeManager.incBytecodes(1);
                    throw ex;
                }
                final int modCount = LinkedHashMap.this.modCount;
                final int expectedModCount = this.expectedModCount;
                BytecodeManager.incBytecodes(6);
                if (modCount != expectedModCount) {
                    BytecodeManager.incBytecodes(3);
                    final ConcurrentModificationException ex2 = new ConcurrentModificationException();
                    BytecodeManager.incBytecodes(1);
                    throw ex2;
                }
                this.current = null;
                BytecodeManager.incBytecodes(3);
                final K key = current.key;
                BytecodeManager.incBytecodes(3);
                final LinkedHashMap this$0 = LinkedHashMap.this;
                final K k = key;
                BytecodeManager.incBytecodes(4);
                final int hash = HashMap.hash(k);
                final K i = key;
                final Object o = null;
                final boolean b = false;
                final boolean b2 = false;
                BytecodeManager.incBytecodes(5);
                this$0.removeNode(hash, i, o, b, b2);
                BytecodeManager.incBytecodes(1);
                this.expectedModCount = LinkedHashMap.this.modCount;
                BytecodeManager.incBytecodes(5);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedKeyIterator extends LinkedHashIterator implements Iterator<K>
    {
        LinkedKeyIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final K next() {
            try {
                BytecodeManager.incBytecodes(2);
                final Entry<Object, Object> nextNode = (Entry<Object, Object>)this.nextNode();
                BytecodeManager.incBytecodes(1);
                final Object key = nextNode.getKey();
                BytecodeManager.incBytecodes(1);
                return (K)key;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedValueIterator extends LinkedHashIterator implements Iterator<V>
    {
        LinkedValueIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final V next() {
            try {
                BytecodeManager.incBytecodes(2);
                final V value = this.nextNode().value;
                BytecodeManager.incBytecodes(2);
                return value;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
    
    final class LinkedEntryIterator extends LinkedHashIterator implements Iterator<Map.Entry<K, V>>
    {
        LinkedEntryIterator() {
            try {
                BytecodeManager.incBytecodes(6);
                BytecodeManager.incBytecodes(1);
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
        
        @Override
        public final Map.Entry<K, V> next() {
            try {
                BytecodeManager.incBytecodes(2);
                final Entry<K, V> nextNode = this.nextNode();
                BytecodeManager.incBytecodes(1);
                return nextNode;
            }
            finally {
                throw loadexception(java.lang.Throwable.class);
            }
        }
    }
}
