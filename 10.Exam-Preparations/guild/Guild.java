package ExamPreparation.guild;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name)).findFirst().get().setRank("Member");
    }

    public void demotePlayer(String name) {
        roster.stream().filter(p -> p.getName().equals(name)).findFirst().get().setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());
        roster = roster.stream().filter(p -> !p.getClazz().equals(clazz)).collect(Collectors.toList());
        Player[] kickPl = new Player[kickedPlayers.size()];
        for (int i = 0; i < kickPl.length; i++) {
            kickPl[i] = kickedPlayers.get(i);
        }
        return kickPl;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", name));
        for (Player pl : roster) {
            sb.append(System.lineSeparator());
            sb.append(pl.toString());
        }
        return sb.toString();
    }
}
