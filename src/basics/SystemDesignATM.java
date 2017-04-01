/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

/**
 *
 * @author marco
 */
interface AtmMachineState {
     void insertDebitCard();
     void ejectDebitCard();
     void enterPinAndWithdrawMoney();
}
 
 class NoDebitCardState implements AtmMachineState{
 
    @Override
    public void insertDebitCard() {
        System.out.println("Debit Card is inserted");
    }
    @Override
    public void ejectDebitCard() {
        System.out.println("No Debit Card in the slot, so you can't eject card");
    }
    @Override
    public void enterPinAndWithdrawMoney() {
        System.out.println("No Debit Card in ATM, so you can't enter pin and password");
    }
}
 
class HasDebitCardState implements AtmMachineState{
    @Override
    public void insertDebitCard() {
        System.out.println("Debit Card is already in the ATM, so you can't insert another");
    }
 
    @Override
    public void ejectDebitCard() {
        System.out.println("Debit card is ejected");
    }
 
    @Override
    public void enterPinAndWithdrawMoney() {
        System.out.println("Pin Card entered correctly, and money has been withdrawn");
    }
}
 
 class AtmMachine implements AtmMachineState {
    private AtmMachineState atmMachineState;
    public AtmMachine(){
        atmMachineState = new NoDebitCardState();
    }
 
    public AtmMachineState getAtmMachineState() {
        return atmMachineState;
    }
 
    public void setAtmMachineState(AtmMachineState atmMachineState) {
        this.atmMachineState = atmMachineState;
    }
 
    @Override
    public void insertDebitCard() {
        atmMachineState.insertDebitCard();
        if(atmMachineState instanceof NoDebitCardState){
            System.out.println("Got here atmMack");
            AtmMachineState hasDebitCardState = new HasDebitCardState();
            setAtmMachineState(hasDebitCardState);
            System.out.println("ATM Machine internal state has been moved to"+atmMachineState.getClass().getName());
        }
    }
 
    @Override
    public void ejectDebitCard() {
        atmMachineState.ejectDebitCard();
        if(atmMachineState instanceof HasDebitCardState){
            System.out.println("Got here atmMack");
            AtmMachineState noDebitCardState = new NoDebitCardState();
            setAtmMachineState(noDebitCardState);
            System.out.println("ATM Machine internal state has been moved to"+atmMachineState.getClass().getName());
        }
    }
 
    @Override
    public void enterPinAndWithdrawMoney() {
        atmMachineState.enterPinAndWithdrawMoney();
    }
}
 public class SystemDesignATM {
    public static void main(String[] args) {
        AtmMachine atmMachine = new AtmMachine();
        System.out.println("ATM Machine Current state:"+ atmMachine.getAtmMachineState().getClass().getName());
        System.out.println();
        atmMachine.enterPinAndWithdrawMoney();
        atmMachine.ejectDebitCard();
        atmMachine.insertDebitCard();
        System.out.println("\n ---------------");
        System.out.println("ATM Machine Current State:"+ atmMachine.getAtmMachineState().getClass().getName());
        System.out.println();
        atmMachine.enterPinAndWithdrawMoney();
        atmMachine.insertDebitCard();
        atmMachine.ejectDebitCard();
 
    }
}

