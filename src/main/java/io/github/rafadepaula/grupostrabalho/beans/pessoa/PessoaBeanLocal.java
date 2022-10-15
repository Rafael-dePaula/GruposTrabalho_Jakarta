package io.github.rafadepaula.grupostrabalho.beans.pessoa;

import io.github.rafadepaula.grupostrabalho.model.entities.Pessoa;

import java.time.LocalDate;
import java.util.List;

public interface PessoaBeanLocal {
    void salvar(Pessoa pessoa);

    List<Pessoa> fetchAll();

    List<Pessoa> fetchAllTyped();

    List<Pessoa> fetchAllNamed();

    List<String> fetchNames();

    List<String> fetchNamesTyped();

    List<String> fetchNamesNamed();

    List<Object[]> fetchNameAndAddress();

    List<Object[]> fetchNameAndAddressTyped();

    List<Object[]> fetchNameAndAddressNamed();

    List<Pessoa> fetchLiveOnAvenue();

    List<Pessoa> fetchLiveOnAvenueTyped();

    List<Pessoa> fetchLiveOnAvenueNamed();

    List<Pessoa> fetchNotLiveOnSquare();

    List<Pessoa> fetchNotLiveOnSquareTyped();

    List<Pessoa> fetchNotLiveOnSquareNamed();

    List<Object[]> fetchNameAndPhone();

    List<Object[]> fetchNameAndPhoneTyped();

    List<Object[]> fetchNameAndPhoneNamed();

    List<Pessoa> fetchBornBetweenDates(LocalDate beginDate, LocalDate endDate);

    List<Pessoa> fetchSameStateOfDDD(Byte ddd);

    List<Pessoa> fetchAllWithoutPhonesNumbers();

    List<Object[]> fetchPhoneNumberCount();
}
