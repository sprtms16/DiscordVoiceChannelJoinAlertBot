package kr.sprtms16.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MemberIOStatus {
    IN("반가워요", "입장하셨습니다."), OUT("잘가요", "퇴장하셨습니다.");
    private String message;
    private String statusMessage;
}
