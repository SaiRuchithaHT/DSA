class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<String> strs = new ArrayList<>(Arrays.asList(products));
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> inner = new ArrayList<>();
            List<String> next = new ArrayList<>();
            for (String product : strs) {
                if (i < product.length() && product.charAt(i) == searchWord.charAt(i)) {
                    if (inner.size() < 3) {
                        inner.add(product);
                    }
                    next.add(product); 
                }
            }
            result.add(inner);
            strs = next; 
        }
        return result;
    }
}
