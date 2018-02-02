package com.tencent.mm.plugin.hp.d;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements Runnable {
    public String fqR;
    public boolean hYW = true;
    public boolean hlj = true;
    public String icu;
    public String url;

    public a(String str, String str2, String str3) {
        this.url = str;
        this.icu = str2;
        this.fqR = str3;
        this.hYW = true;
    }

    public final void run() {
        Throwable e;
        InputStream inputStream;
        OutputStream outputStream;
        u uVar;
        u uVar2 = null;
        OutputStream outputStream2 = null;
        try {
            uVar2 = b.a(this.url, null);
            try {
                uVar2.setRequestMethod("GET");
                uVar2.setConnectTimeout(15000);
                uVar2.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                if (b.a(uVar2) != 0) {
                    x.e("Tinker.TinkerDownloadTask", "checkHttpConnection failed! url:%s", new Object[]{this.url});
                    return;
                }
                InputStream inputStream2 = uVar2.getInputStream();
                if (inputStream2 == null) {
                    try {
                        x.d("Tinker.TinkerDownloadTask", "getInputStream failed. url:%s", new Object[]{this.url});
                        return;
                    } catch (InterruptedException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 32, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e)});
                        if (uVar != null) {
                            try {
                                uVar.aBw.disconnect();
                            } catch (Throwable e3) {
                                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                                x.e("Tinker.TinkerDownloadTask", "close conn failed : %s", new Object[]{e3.getMessage()});
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (UnknownHostException e4) {
                        e3 = e4;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 33, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SSLHandshakeException e5) {
                        e3 = e5;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 34, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketException e6) {
                        e3 = e6;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 35, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketTimeoutException e7) {
                        e3 = e7;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 36, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (IOException e8) {
                        e3 = e8;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 37, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (Exception e9) {
                        e3 = e9;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                        this.hlj = true;
                        g.pQN.a(614, 38, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    }
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                outputStream2 = FileOp.iE(this.icu);
                while (true) {
                    try {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                    } catch (InterruptedException e10) {
                        e3 = e10;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (UnknownHostException e11) {
                        e3 = e11;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (SSLHandshakeException e12) {
                        e3 = e12;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (SocketException e13) {
                        e3 = e13;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (SocketTimeoutException e14) {
                        e3 = e14;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (IOException e15) {
                        e3 = e15;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    } catch (Exception e16) {
                        e3 = e16;
                        inputStream = inputStream2;
                        outputStream = outputStream2;
                        uVar = uVar2;
                    }
                }
                this.hlj = false;
                outputStream2.close();
                outputStream = null;
                try {
                    uVar2.aBw.disconnect();
                    uVar = null;
                } catch (InterruptedException e17) {
                    e3 = e17;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 32, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (UnknownHostException e18) {
                    e3 = e18;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 33, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SSLHandshakeException e19) {
                    e3 = e19;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 34, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketException e20) {
                    e3 = e20;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 35, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketTimeoutException e21) {
                    e3 = e21;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 36, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (IOException e22) {
                    e3 = e22;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 37, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (Exception e23) {
                    e3 = e23;
                    inputStream = inputStream2;
                    uVar = uVar2;
                    this.hlj = true;
                    g.pQN.a(614, 38, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                }
                try {
                    inputStream2.close();
                    inputStream = null;
                    try {
                        if (!com.tencent.mm.a.g.bV(this.icu).equalsIgnoreCase(this.fqR)) {
                            x.d("Tinker.TinkerDownloadTask", "hp_apply md5 mismatched, ignored");
                            g.pQN.a(614, 30, 1, false);
                            this.hlj = true;
                        }
                    } catch (InterruptedException e24) {
                        e3 = e24;
                        this.hlj = true;
                        g.pQN.a(614, 32, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (UnknownHostException e25) {
                        e3 = e25;
                        this.hlj = true;
                        g.pQN.a(614, 33, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SSLHandshakeException e26) {
                        e3 = e26;
                        this.hlj = true;
                        g.pQN.a(614, 34, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketException e27) {
                        e3 = e27;
                        this.hlj = true;
                        g.pQN.a(614, 35, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (SocketTimeoutException e28) {
                        e3 = e28;
                        this.hlj = true;
                        g.pQN.a(614, 36, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (IOException e29) {
                        e3 = e29;
                        this.hlj = true;
                        g.pQN.a(614, 37, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    } catch (Exception e30) {
                        e3 = e30;
                        this.hlj = true;
                        g.pQN.a(614, 38, 1, false);
                        x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream == null) {
                            outputStream.close();
                        }
                    }
                } catch (InterruptedException e31) {
                    e3 = e31;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 32, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (UnknownHostException e32) {
                    e3 = e32;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 33, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SSLHandshakeException e33) {
                    e3 = e33;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 34, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketException e34) {
                    e3 = e34;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 35, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (SocketTimeoutException e35) {
                    e3 = e35;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 36, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (IOException e36) {
                    e3 = e36;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 37, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                } catch (Exception e37) {
                    e3 = e37;
                    inputStream = inputStream2;
                    this.hlj = true;
                    g.pQN.a(614, 38, 1, false);
                    x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream == null) {
                        outputStream.close();
                    }
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (InterruptedException e38) {
                e3 = e38;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 32, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (UnknownHostException e39) {
                e3 = e39;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 33, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SSLHandshakeException e40) {
                e3 = e40;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 34, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SocketException e41) {
                e3 = e41;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 35, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (SocketTimeoutException e42) {
                e3 = e42;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 36, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (IOException e43) {
                e3 = e43;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 37, 1, false);
                x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            } catch (Exception e44) {
                e3 = e44;
                inputStream = null;
                outputStream = outputStream2;
                uVar = uVar2;
                this.hlj = true;
                g.pQN.a(614, 38, 1, false);
                x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    outputStream.close();
                }
            }
        } catch (InterruptedException e45) {
            e3 = e45;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 32, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (UnknownHostException e46) {
            e3 = e46;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 33, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SSLHandshakeException e47) {
            e3 = e47;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 34, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SocketException e48) {
            e3 = e48;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 35, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (SocketTimeoutException e49) {
            e3 = e49;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 36, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (IOException e50) {
            e3 = e50;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 37, 1, false);
            x.e("Tinker.TinkerDownloadTask", "[cpan] get image data failed.:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        } catch (Exception e51) {
            e3 = e51;
            inputStream = null;
            outputStream = outputStream2;
            uVar = uVar2;
            this.hlj = true;
            g.pQN.a(614, 38, 1, false);
            x.e("Tinker.TinkerDownloadTask", "exception:%s", new Object[]{bh.i(e3)});
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                outputStream.close();
            }
        }
    }
}
