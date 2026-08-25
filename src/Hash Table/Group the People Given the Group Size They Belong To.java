class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> waitingRooms = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            if (!waitingRooms.containsKey(size)) {
                waitingRooms.put(size, new ArrayList<>());
            }

            waitingRooms.get(size).add(i);

            if (waitingRooms.get(size).size() == size) {
                result.add(waitingRooms.get(size));
                waitingRooms.remove(size);
            }
        }

        return result;
    }
}