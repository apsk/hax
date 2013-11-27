package com.github.apsk.hax.parser.arity;

import com.github.apsk.hax.parser.Parser;
import com.github.apsk.j8t.Tuple7;

import static com.github.apsk.j8t.Tuples.tuple;

@FunctionalInterface
public interface Parser7<A,B,C,D,E,F,G> extends Parser<Tuple7<A,B,C,D,E,F,G>> {
    default <H> Parser8<A,B,C,D,E,F,G,H> and(Parser<H> p) {
        return r -> {
            Tuple7<A,B,C,D,E,F,G> lhs = this.run(r);
            H rhs = p.run(r);
            return tuple(lhs._1, lhs._2, lhs._3, lhs._4, lhs._5, lhs._6, lhs._7, rhs);
        };
    }
    default Parser7<A,B,C,D,E,F,G> nextL(Parser<?> p) {
        return r -> {
            Tuple7<A,B,C,D,E,F,G> result = this.run(r);
            p.run(r);
            return result;
        };
    }
}
