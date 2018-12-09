
package statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import statistics.matcher.*;

public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        matcher = new All(null);
    }

    public Matcher build() {
        Matcher output = matcher;
        matcher = new All(null);

        return output;
    }

    QueryBuilder all(Matcher matcher) {
        this.matcher = new All(matcher);
        return this;
    }

    QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }

    QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }

    QueryBuilder not() {
        this.matcher = new Not(matcher);
        return this;
    }

    QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    QueryBuilder anyOf(Matcher... matchers) {
        List<Matcher> matcherList = new ArrayList<>(Arrays.asList(matchers));
        Matcher[] matcherArray = new Matcher[matcherList.size()];

        this.matcher = new Or(matcherList.toArray(matcherArray));
        return this;
    }
}
