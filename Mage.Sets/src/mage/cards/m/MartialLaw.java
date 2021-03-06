
package mage.cards.m;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.effects.common.DetainTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.TargetController;
import mage.filter.common.FilterCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 * @author LevelX2
 */
public final class MartialLaw extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("creature an opponent controls");
 
    static {
        filter.add(TargetController.OPPONENT.getControllerPredicate());
    }

    public MartialLaw(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{2}{W}{W}");


        // At the beginning of your upkeep, detain target creature an opponent controls. 
        // (Until your next turn, that creature can't attack or block and its activated abilities can't be activated.)
        Ability ability = new BeginningOfUpkeepTriggeredAbility(new DetainTargetEffect(), TargetController.YOU, false);
        TargetCreaturePermanent target = new TargetCreaturePermanent(filter);
        ability.addTarget(target);
        this.addAbility(ability);
    }

    public MartialLaw(final MartialLaw card) {
        super(card);
    }

    @Override
    public MartialLaw copy() {
        return new MartialLaw(this);
    }
}
