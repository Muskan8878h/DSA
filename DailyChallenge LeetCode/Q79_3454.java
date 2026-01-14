class Solution {
    static class Event {
        long y;
        int x1, x2;
        int type;
        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }
    static class SegTree {
        int n;
        long[] length;
        int[] cover;
        long[] xs;

        SegTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            length = new long[4 * n];
            cover = new int[4 * n];
        }

        void update(int idx, int l, int r, int ql, int qr, int v) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                cover[idx] += v;
            } else {
                int mid = (l + r) / 2;
                update(idx * 2, l, mid, ql, qr, v);
                update(idx * 2 + 1, mid, r, ql, qr, v);
            }
            if (cover[idx] > 0) {
                length[idx] = xs[r] - xs[l];
            } else {
                length[idx] = (l + 1 == r) ? 0 : length[idx * 2] + length[idx * 2 + 1];
            }
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int[] s : squares) {
            set.add((long) s[0]);
            set.add((long) s[0] + s[2]);
        }

        long[] xs = new long[set.size()];
        int idx = 0;
        for (long x : set) xs[idx++] = x;

        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        List<Event> events = new ArrayList<>();
        for (int[] s : squares) {
            int l = xIndex.get((long) s[0]);
            int r = xIndex.get((long) s[0] + s[2]);
            events.add(new Event(s[1], l, r, 1));
            events.add(new Event((long) s[1] + s[2], l, r, -1));
        }

        events.sort(Comparator.comparingLong(e -> e.y));
        SegTree st = new SegTree(xs);
        double total = 0;
        long prevY = events.get(0).y;
        for (Event e : events) {
            total += st.query() * (e.y - prevY);
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }

        double half = total / 2.0;

        st = new SegTree(xs);
        prevY = events.get(0).y;
        double area = 0;
        for (Event e : events) {
            double slab = st.query() * (e.y - prevY);
            if (area + slab >= half) {
                return prevY + (half - area) / st.query();
            }
            area += slab;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }
        return prevY;
    }
}
