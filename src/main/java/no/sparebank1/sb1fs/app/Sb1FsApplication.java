package no.sparebank1.sb1fs.app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import io.vavr.Tuple;
import no.sparebank1.sb1fs.api.accounts.Account;
import no.sparebank1.sb1fs.api.accounts.Balance;
import no.sparebank1.sb1fs.api.accounts.Sb1Accounts;
import no.sparebank1.sb1fs.api.transactions.APITransactions;
import no.sparebank1.sb1fs.fs.DirNode;
import no.sparebank1.sb1fs.fs.FileNode;
import no.sparebank1.sb1fs.fs.Node;
import no.sparebank1.sb1fs.fs.Sb1fs;
import no.sparebank1.sb1fs.util.Java8Util;
import no.sparebank1.sb1fs.util.UniRest;
import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static no.sparebank1.sb1fs.util.CommandLine.*;


public class Sb1FsApplication {

    private static Logger LOG = LoggerFactory.getLogger(Sb1FsApplication.class);

    public static void main(String[] args) throws IOException {
        CommandLine commandLine = generateCommandLine(args);

        String token = commandLine.getOptionValue(OPTION_TOKEN);
        String mountPath = commandLine.getOptionValue(OPTION_MOUNT_PATH);

        if (commandLine.hasOption(OPTION_HELP) || token == null) {
            printUsage();
            System.exit(0);
        }

        LOG.info("Token to use: {}", token.substring(0, token.length() - 10) + "**********");
        LOG.info("Mount path:   {}", mountPath);


        UniRest.configureUnirest();


        HttpResponse<Sb1Accounts> response = Java8Util.propagate(() -> Unirest
                .get("https://developer-api.sparebank1.no/open/personal/banking/accounts/all")
                .header("Accept", "application/vnd.sparebank1.v1+json")
                .header("Authorization", "Bearer " + token)
                .asObject(Sb1Accounts.class));

        Sb1Accounts sb1Accounts = response.getBody();

        DirNode root = new DirNode("/",
                Arrays.stream(sb1Accounts.getAccounts())
                        .map(account ->
                                new DirNode((account.getAccountNumber().getFormatted() + " " + account.getName()).replaceAll("\\W", "_"),
                                        getSubnodes(token, account))
                        ).collect(Collectors.toList()));


        new Sb1fs(root, mountPath).mount();

        System.in.read();

    }

    private static List<Node> getSubnodes(String token, Account account) {

        /**
         * TODO: Implement something more interesting here!
         *
         * Check no.sparebank1.sb1fs.saul.SaulFs for some inspiration.
         *
         */

        Balance balance = account.getBalance();

        return List.of(
                new DirNode("konto", List.of(new FileNode(account.getName(), ""))),
                new DirNode("saldo",
                        List.of(new FileNode(balance.getAmount() + "." + (balance.getCurrencyCode().equals("NOK") ? "kr" : balance.getCurrencyCode()), ""))),
                new DirNode("transactions", getTransactions(token, account)));
    }

    private static List<Node> getTransactions(String token, Account account) {
        String url = account.getLinks().getTransactions().getHref();

        HttpResponse<APITransactions> transactions = Java8Util.propagate(() -> Unirest.get(url)
                .header("Accept", "application/vnd.sparebank1.v1+json")
                .header("Authorization", "Bearer " + token)
                .asObject(APITransactions.class));

        return Arrays.stream(transactions.getBody().getTransactions())
                .map(t ->
                        new FileNode(String.format("%s: %-30s %3s %10.2f",
                                t.getAccountingDate(),
                                t.getDescription(),
                                t.getAmount().getCurrencyCode(),
                                t.getAmount().getAmount()),
                                "Arkivreferanse: " + Optional.ofNullable(t.getArchiveReference()).orElse("") + "\n" +
                                        "Transaksjonstype: " + t.getTransactionType() + "\n" +
                                        "Fjernkonto: " + Optional.ofNullable(t.getRemoteAccount()).orElse("") + "\n"))
                .collect(Collectors.toList());
    }
}
